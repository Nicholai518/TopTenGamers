package sample;

public class BubbleSort
{

    // Fields
    private String[] array;
    private int lastPosition;
    private int index;
    private String temp;

    // Constructor
    public BubbleSort(String[] array)
    {
        this.array = array;
    }

    // Methods

    public String[] getArray()
    {
        return array;
    }

    public void setArray(String[] array)
    {
        this.array = array;
    }

    public int getLastPosition()
    {
        return lastPosition;
    }

    public void setLastPosition(int lastPosition)
    {
        this.lastPosition = lastPosition;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getTemp()
    {
        return temp;
    }

    public void setTemp(String temp)
    {
        this.temp = temp;
    }


    public void sort()
    {
        for(lastPosition = array.length -1; lastPosition>=0; lastPosition--)
        {
            // Inner loop
            for(index = 0; index <= lastPosition -1; index++)
            {

                // compare an element with its neighbor
                if( (array[index].compareTo(array[index + 1]) >  0 ))
                {
                    // swap elements if index is greater than index +1
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }

            }
        }
    }

    @Override
    public String toString()
    {
        String values = "";

        for(int j =0; j < array.length; j++)
        {
            values = values + " " + array[j];
        }
        return values;
    }
}

