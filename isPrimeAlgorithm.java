public static boolean isPrime(int number)
{
    if(number == 2)
        return true; // '2' is the only even number that is prime;

    int divisiblesCount = 1; // including the number '1'
    for(int index = 2; index <= number; index++)
    {
        if(number % index == 0)
            divisiblesCount++;

        if(divisiblesCount > 2)
            return false; // the number is not prime;
    }
    return true; //the number is prime;
}