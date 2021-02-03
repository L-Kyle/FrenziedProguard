public class ProgardEx {
 
    public static void main(String[] args) {
        try {
            genWordsTxt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
    private static void genWordsTxt() {
        List<String> list = new ArrayList<>();
        list.addAll(getStringList(0xFE70, 0xFFFF));//各种符号
 
        int wordsLength = 6;
        writeToText(list, wordsLength);
    }
 
    private static List<String> getStringList(int start, int end) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String s = String.valueOf((char) i);
            list.add(s);
        }
        return list;
    }
 
    private static void writeToText(List<String> list, int wordsLength) {
 
        String outTxt = "/sdcard/guard_ex.txt";
        try {
            int count = list.size();
            PrintWriter writer = new PrintWriter(new File(outTxt));
            for (int i = 0; i < count; i++) {
 
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < wordsLength; j++) {
                    sb.append(getRandomItem(list));
                }
                writer.println(sb.toString());
                System.out.println("write:" + sb);
            }
             writer.close();
            System.out.println("write Done,Cout:" + count);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail!");
        }
    }
 
    private static String getRandomItem(List<String> list) {
        long max = list.size() - 1;
        long min = 0;
        double valueD = (Math.random() * (max - min) + min);//5-10s
        int value = (int) valueD;
        return list.get(value);
    }
}