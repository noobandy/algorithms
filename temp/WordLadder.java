import java.util.*;

class WordLadder {
    
    private List<String> choices(List<String> wordList, String currentWord) {
        
        List<String> choices = new ArrayList<String>();

        for(String word : wordList) {
            int distance = 0;
            for(int i = 0; i < currentWord.length(); i++) {
                if(word.charAt(i) != currentWord.charAt(i)) {
                    distance++;
                }
                
                if(distance > 1) {
                    break;
                }
            }
            
            if(distance == 1) {
                choices.add(word);
            }
        }
        
        return choices;
    }
    
    private List<List<String>> result;
    private int min;
    private List<String> steps;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList<List<String>>();
        min = Integer.MAX_VALUE;
        steps = new ArrayList<String>();

        _findLadders(beginWord, endWord, wordList);

        return result;
    }

    private List<String> copy(List<String> steps) {
        List<String> copy = new ArrayList<String>();
        for(String step: steps) {
            copy.add(step);
        }

        return copy;
    }

    private void _findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!beginWord.equals(endWord) && steps.size() < min) {
            List<String> choices = choices(wordList, beginWord);
            for(String choice: choices) {
                if(!steps.contains(choice)) {
                    steps.add(choice);
                    _findLadders(choice, endWord, wordList);
                    if(endWord.equals(steps.get(steps.size() -1))) {
                        if(steps.size() < min) {
                            result.clear();
                            result.add(copy(steps));
                            min = steps.size();
                        } else if(steps.size() > min) {
                            // do nothing
                        } else {
                            result.add(copy(steps));
                        }
                    }
                    
                    steps.remove(choice);
                }
            }
        }
    }
     

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<List<String>> wordLadders = wl.findLadders("qa", "sq", Arrays.asList(new String[] {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"}));
        
        for(List<String> wordLadder: wordLadders) {
            System.out.println(Arrays.toString(wordLadder.toArray()));
        }
    }
}