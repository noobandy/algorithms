import java.util.*;

public class Friends {

	private int[] friends;
	private int[] sizes;
	private int friendGroups; 

	public Friends(int people) {
		super();
		friends = new int[people];
		sizes = new int[people];

		for(int i = 0; i< people; i++) {
			friends[i] = i;
			sizes[i] = 1;
		}

		friendGroups = people;
	}

	private int find(int person) {
		int curr = friends[person];

		while(curr != friends[curr]) {
			friends[curr] = friends[friends[curr]];
			curr = friends[curr];
		}

		return curr;
	}
	public boolean beFriend(int person1, int person2) {
		int friendGroupOfPerson1 = find(person1);
		int friendGroupOfPerson2 = find(person2);
		
		if(friendGroupOfPerson1 != friendGroupOfPerson2) {

			if(sizes[friendGroupOfPerson1] <= sizes[friendGroupOfPerson2]) {
				friends[friendGroupOfPerson1] = friendGroupOfPerson2;
				sizes[friendGroupOfPerson2] = sizes[friendGroupOfPerson2] + sizes[friendGroupOfPerson1];
			} else {
				friends[friendGroupOfPerson2] = friendGroupOfPerson2;
				sizes[friendGroupOfPerson1] = sizes[friendGroupOfPerson1] + sizes[friendGroupOfPerson2];
			}

			friendGroups--;
			
			return true;
		} else {
			return false;
		}
	}

	public boolean areFriend(int person1, int person2) {
		return find(person1) == find(person2);
	}

	public int friendGroups() {
		return friendGroups;
	}

	public int peopleInFriendGroup(int person) {
		return sizes[find(person)];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int people = scanner.nextInt();
		int command = scanner.nextInt();
		int query = scanner.nextInt();

		Friends friends = new Friends(people);

		for(int i = 0; i < command; i++) {
			int person1 = scanner.nextInt();
			int person2 = scanner.nextInt();

			friends.beFriend(person1 - 1, person2 - 1);
		}

		System.out.println(friends.friendGroups());

		for(int i = 0; i < query; i++) {
			int person1 = scanner.nextInt();
			int person2 = scanner.nextInt();

			System.out.println(friends.peopleInFriendGroup(person1 - 1));
			System.out.println(friends.peopleInFriendGroup(person2 - 1));

			System.out.format("%d and %d are %s friends.%n", person1, person2, 
				friends.areFriend(person1 - 1, person2 - 1) ? "" : "not");
		}
	}
}