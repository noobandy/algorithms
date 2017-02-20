	package algorithms.uf;

	public class QuickFindUF implements UF {
		private int[] objects;

		public QuickFindUF(int n) {
			super();
			objects = new int[n];
			for(int i = 0; i < objects.length; i++) {
				objects[i] = i;
			}
		}
		
		public boolean union(int object1, int object2) {

			if(objects[object1] == objects[object2]) {
				//already connected
				return false;
			} else {
				
				for(int i = 0; i < objects.length; i++) {
						if(objects[i] == objects[object2]) {
							objects[i] = objects[object1];
						}
					}

				return true;
			}
		}

		public boolean connected(int object1, int object2) {

			return objects[object1] == objects[object2];
		}
	}