package lambda;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HLambda {

    public static void main( String[] args ) {
        new HLambda().run();
    }

    public void run() {

        List<Number> numbers = Arrays.asList( 1, 2, 3 );
        numbers.forEach( i -> System.out.println( i ) );
        System.out.println( "Done" );

        IntFunction<String> intToString = Integer::toString;

        System.out.printf( "%s %s \n", "-------------", intToString.apply( 123 ) );

//        Function<Integer, String> intToString1 = Integer::toString;

        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println( newBigInt );
        System.out.println( newBigInt.apply( "321" ) );

        Consumer<String> print = System.out::println;
        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        IntFunction<String> lookup = Arrays.asList( "a", "b", "c" )::get;


        print.accept( "qweqweqwe**\n\n" );
        System.out.println( makeGreeting.apply( "werwer\n\n" ) );
        System.out.println( lookup.apply( 2 ) );

        //method reference -- can be used after q goes out of scope -- ie null.
        Q q = new Q();

        Function<String, String> do1 = q::do1;
        System.out.println( do1.apply( "qqrq1" ) );

        q.setQwe( "wer" );
        System.out.println( do1.apply( "qqrq1" ) );

        q.setQwe( "wer3" );
        System.out.println( do1.apply( "qqrq3" ) );

        q = null;
        System.out.println( do1.apply( "qqrq4" ) );

        //uses prev instance ==> lambda captures object it was created from
        q = new Q();
        q.setQwe( "wer33" );
        System.out.println( do1.apply( "qqrq33" ) );

        System.out.println( "---------------------------------" );

        Function<Integer, String> f = ( Integer inp ) -> Integer.toString( inp );
        System.out.println( "f: " + f );
//        Function<Integer,Double> f = Integer::doubleValue;
        f = f.andThen( "10"::concat ).andThen( "22 "::concat );
        System.out.println( "f: " + f );
        System.out.println( f.getClass().toString() );
        System.out.println( f.apply( 12 ) );

        Predicate<Integer> evenNumber = n -> n % 2 == 0;

        System.out.println( evenNumber.test( 1000 ) );
        System.out.println( evenNumber.test( new Integer( 123123 ) ) );

        IntPredicate oddNumber = n -> n % 2 == 1;
        System.out.println( oddNumber.test( 131 ) );

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream( arrayOfWords );
        streamOfwords.forEach( System.out::println );


        System.out.println( "=======================" );
        //chain of responsibility
        UnaryOperator<String> p1 = text -> "Hello header: " + text;
        UnaryOperator<String> p2 = text -> "Hello footer: " + text;

        Function<String, String> aFunction = p1.andThen( p2 );

        System.out.println( aFunction.apply( "qwe" ) );

        //1 arg
        Function<String, Integer> strToInt = Integer::parseInt;
        System.out.println( strToInt.apply( "1231" ) );

        //2 arg
        BiFunction<String, Integer, Integer> strToInt1 = Integer::parseInt;
        System.out.println( strToInt1.apply( "32", 16 ) );


        multilevel();

    }

    private void multilevel() {

        System.out.println("Multilevel-----------------\n");

        City aCity = new City( "ACity" );

        District a1dist = aCity.addDistrict( "A1Dist" );
        a1dist.addStreet( "A1Dist-a11Street" );
        a1dist.addStreet( "A1Dist-a12Street" );
        District a2dist = aCity.addDistrict( "A2Dist" );
        a2dist.addStreet( "A2Dist-a21Street" );
        a2dist.addStreet( "A2Dist-a22Street" );

        aCity.districts.stream().flatMap( district -> district.streets.stream() ).forEach(a-> {
            System.out.println("" + a.getName());
        } );


        System.out.println("\nMultilevel---END-----------------");
    }

}


class Q {
    String qwe;

    public String getQwe() {
        return qwe;
    }

    public void setQwe( String qwe ) {
        this.qwe = qwe;
    }

    public String do1( String str ) {
        return " * " + qwe + " ** " + str;
    }
}

class City {
    private final String name;
    List<District> districts = new ArrayList<>();

    public City( String name ) {
        this.name = name;

    }

    public District addDistrict( String name ) {
        District district = new District( name );
        districts.add( district );
        return district;
    }

}

class District {

    private final String name;
    List<Street> streets = new ArrayList<>();

    public District( String name ) {
        this.name = name;
    }


    public Street addStreet( String name ) {
        Street street = new Street( name );
        streets.add( street );
        return street;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "District{" );
        sb.append( "name='" ).append( name ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}


class Street {

    private final String name;

    public Street( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Street{" );
        sb.append( "name='" ).append( name ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}
