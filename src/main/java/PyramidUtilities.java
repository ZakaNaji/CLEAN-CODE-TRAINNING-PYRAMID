public class PyramidUtilities {
    public static int getNumberOfSlaves(String layerOrder){
        String slavesNumberSpecification = layerOrder.split(",")[0];
        String slavesNumbersAsString = slavesNumberSpecification.split(" ")[0] ;
        int slaveNumberAsInt = Integer.parseInt(slavesNumbersAsString) ;
        return slaveNumberAsInt;
    }
    public static int getLayerBudget(String layerOrder){
        String budgetSpecification = layerOrder.split(",")[1];
        String budgetAsString = budgetSpecification.split(" ")[1];
        int budgetAsInt = Integer.parseInt(budgetAsString);
        return budgetAsInt;
    }
}
