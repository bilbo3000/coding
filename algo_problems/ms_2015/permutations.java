input = abcd

input abc -> bc, cb -> abc, bac, bca, acb, cab, cba

void Permutations_iter(String input) {
    List<List<Character>> result = new ArrayList<List<Character>>(); 
    int len = input.length(); 
    int i = len - 1; 
    
    while (i >= 0) {
        if (i == len - 1) {
            List<Character> temp = ArrayList<Character>(); 
            temp.add(input.charAt(i));
            result.add(temp);
        } else {
            int size = result.size(); 
            
            for (int j = size - 1; j >= 0; j--) {
                List<Character> temp = result.get(j); 
                
                for (int k = 0; k < temp; k++) {
                    List<Character> copy = new ArrayList<Character>(temp);
                    copy.add(k, input.charAt(i));
                    result.add(copy);
                }
                
                List<Character> copy = new ArrayList<Character>(temp);
                copy.add(input.charAt(i));
                result.add(copy);
                
                result.remove(j);
            }
        }
        
        i--; 
    } // while 
    
    for (List<Character> item : result) {
        System.out.println(item);
    }
}

void Permutations(string input)
{
    List<List<Character>> result = helper(input);
    
    for (List<Character> item : result)  {
        System.out.println(item); 
    }
}

List<List<Character>> helper (String s) {
    List<List<Character>> result = new ArrayList<List<Character>>(); 
    
    if (s == null || s.length() == 0) {
        result.add(new ArrayList<Character>());
        return result; 
    }
    
    if (s.length() == 1) {
        List<Character> temp = new ArrayList<Character>(); 
        temp.add(s.charAt(0));
        result.add(temp);
        return result; 
    }
    
    List<List<Character>> tempResult = helper(s.substring(1)); 
    char firstChar = s.charAt(0); 
    
    for (List<Character> item : tempResult) {
        for (int i = 0; i < item.size(); i++) {
            List<Character> copy = new ArrayList<Character>(item); 
            copy.add(i, firstChar);
            result.add(copy);
        }
        
        List<Character> copy = new ArrayList<Character>(item); 
        copy.add(firstChar);
        result.add(copy);

    }
    
    return result; 
}
