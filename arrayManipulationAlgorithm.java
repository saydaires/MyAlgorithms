public static double[] arrayManipulation(int[] array)
{
    int sumArray = 0;
    int maxElement = array[0];
    int minElement = array[0];
    int allEven = 1;
    
    for(int index = 0; index < array.length; index++)
    {
        sumArray += array[index];

        if(maxElement < array[index])
            maxElement = array[index];

        if(minElement > array[index])
            minElement = array[index];

        if(array[index] % 2 != 0)
            allEven = 0;
    }
    double arithmeticMean = (double) sumArray / array.length;

    double[] arrayData = {sumArray, arithmeticMean, allEven, maxElement, minElement};
    return arrayData;
}