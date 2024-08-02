public static boolean isPrime(int number)
{
    if(number < 2)
        return false; // any number less than 2 is not prime;
    if(number == 2)
        return true; // '2' is the only even number that is prime;
    if(number % 2 == 0)
        return false; // this verify eliminated any number bigger than 2 that is even;

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
