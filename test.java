public class Test{
    public static void main(String[] args){
        String age = "31";
        int n = Integer.parseInt(age);
        System.out.println("来年は"+(n+1)+"歳になります");

        int r = new java.util.Random().nextInt(31);
        System.out.println("乱数は"+r);
    }
    
}