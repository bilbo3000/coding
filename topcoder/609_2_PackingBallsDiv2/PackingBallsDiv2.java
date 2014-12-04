import java.util.*;

// fail on large input such as 
// 78, 53, 64
// 100, 100, 100
public class PackingBallsDiv2 {
    public int minPacks(int R, int G, int B) {
        Set<List<String>> s = new HashSet<List<String>>();

        // Add reds
        while (R > 0) {
            if (s.size() == 0) {
                List<String> temp = new ArrayList<String>();
                temp.add("0");
                s.add(temp);
            } else {
                Set<List<String>> temp = new HashSet<List<String>>();

                for (List<String> item : s) {
                    for (int i = 0; i < item.size(); i++) {
                        String str = item.get(i);

                        if (str.length() == 1) { // add
                            str += '0';
                            List<String> newItem = new ArrayList<String>(item);
                            newItem.set(i, str);
                            Collections.sort(newItem);
                            temp.add(newItem);
                        } else if (str.length() == 2) {
                            char c0 = str.charAt(0);
                            char c1 = str.charAt(1);

                            if (c0 == c1) {
                                if (c0 == '0') {
                                    str += '0';
                                    List<String> newItem = new ArrayList<String>(item);
                                    newItem.set(i, str);
                                    Collections.sort(newItem);
                                    temp.add(newItem);
                                }
                            } else if (c0 != '0' && c1 != '0') {
                                str += '0';
                                List<String> newItem = new ArrayList<String>(item);
                                newItem.set(i, str);
                                Collections.sort(newItem);
                                temp.add(newItem);
                            }
                        }
                    }

                    item.add("0");
                    Collections.sort(item);
                    temp.add(item);
                    s = temp;
                }
            }
            R--;
        }

        // Add green
        while (G > 0) {
            if (s.size() == 0) {
                List<String> temp = new ArrayList<String>();
                temp.add("1");
                s.add(temp);
            } else {
                Set<List<String>> temp = new HashSet<List<String>>();

                for (List<String> item : s) {
                    for (int i = 0; i < item.size(); i++) {
                        String str = item.get(i);

                        if (str.length() == 1) { // add
                            str += '1';
                            List<String> newItem = new ArrayList<String>(item);
                            newItem.set(i, str);
                            Collections.sort(newItem);
                            temp.add(newItem);
                        } else if (str.length() == 2) {
                            char c0 = str.charAt(0);
                            char c1 = str.charAt(1);

                            if (c0 == c1) {
                                if (c0 == '1') {
                                    str += '1';
                                    List<String> newItem = new ArrayList<String>(item);
                                    newItem.set(i, str);
                                    Collections.sort(newItem);
                                    temp.add(newItem);
                                }
                            } else if (c0 != '1' && c1 != '1') {
                                str += '1';
                                List<String> newItem = new ArrayList<String>(item);
                                newItem.set(i, str);
                                Collections.sort(newItem);
                                temp.add(newItem);
                            }
                        }
                    }

                    item.add("1");
                    Collections.sort(item);
                    temp.add(item);
                    s = temp;
                }
            }
            G--;
        }

        // Add blues
        while (B > 0) {
            if (s.size() == 0) {
                List<String> temp = new ArrayList<String>();
                temp.add("2");
                s.add(temp);
            } else {
                Set<List<String>> temp = new HashSet<List<String>>();

                for (List<String> item : s) {
                    for (int i = 0; i < item.size(); i++) {
                        String str = item.get(i);

                        if (str.length() == 1) { // add
                            str += '2';
                            List<String> newItem = new ArrayList<String>(item);
                            newItem.set(i, str);
                            Collections.sort(newItem);
                            temp.add(newItem);
                        } else if (str.length() == 2) {
                            char c0 = str.charAt(0);
                            char c1 = str.charAt(1);

                            if (c0 == c1) {
                                if (c0 == '2') {
                                    str += '2';
                                    List<String> newItem = new ArrayList<String>(item);
                                    newItem.set(i, str);
                                    Collections.sort(newItem);
                                    temp.add(newItem);
                                }
                            } else if (c0 != '2' && c1 != '2') {
                                str += '2';
                                List<String> newItem = new ArrayList<String>(item);
                                newItem.set(i, str);
                                Collections.sort(newItem);
                                temp.add(newItem);
                            }
                        }
                    }

                    item.add("2");
                    Collections.sort(item);
                    temp.add(item);
                    s = temp;
                }
            }
            B--;
        }

        int result = Integer.MAX_VALUE;

        for (List<String> item : s) {
            if (item.size() < result) {
                result = item.size();
            }
        }

        return result;
    }
}
