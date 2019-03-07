public class TEST {
    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid();
        pyramid.addLayer("250 Slaves, 10 Anks");
        pyramid.addLayer("50 Slaves, 3 Anks");
        pyramid.addLayer("150 Slaves, 6 Anks");
        System.out.println(pyramid.print());
    }
}
