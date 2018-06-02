package gui.pizza;
 
public class Configuration
{
 
    private String[] sizeName, toppingNames;
    private int[]    sizePrice, toppingPrices;
    private int      numberOfDefaultToppings;
 
    public Configuration(String[] nSizeName, int[] nSizePrice,
            String[] nToppingNames, int[] nToppingPrices,
            int nNumberOfDefaultToppings)
    {
        if (nSizeName.length != nSizePrice.length
                || nToppingNames.length != nToppingPrices.length
                || nNumberOfDefaultToppings > nToppingNames.length)
        {
            throw new IllegalArgumentException();
        }
        this.sizeName = nSizeName;
        this.toppingNames = nToppingNames;
        this.sizePrice = nSizePrice;
        this.toppingPrices = nToppingPrices;
        this.numberOfDefaultToppings = nNumberOfDefaultToppings;
    }
 
    public int getNumberOfDefaultToppings()
    {
        return numberOfDefaultToppings;
    }
 
    public String[] getSizeNames()
    {
        return sizeName;
    }
 
    public String[] getToppingNames()
    {
        return toppingNames;
    }
 
    public int[] getSizePrices()
    {
        return sizePrice;
    }
 
    public int[] getToppingPrices()
    {
        return toppingPrices;
    }
}