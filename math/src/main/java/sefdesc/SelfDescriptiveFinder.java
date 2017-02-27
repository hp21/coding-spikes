package sefdesc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212587419 on 2017-02-24.
 */
public class SelfDescriptiveFinder implements ISelfDescriptiveFinder {
    @Override
    public List<Long> find( int base ) {
        if ( base <= 1 ) {
            throw new IllegalArgumentException( "Based must be greater than 1, was " + base );
        }
        List<Long> result = new ArrayList<>();

        //0 most significant, b-1 least significant
        int[] work = new int[base];

        while ( canIncrease( work ) ) {
            if ( checkForOkNumber( work ) ) {
                long myNumber = createNumber( work );
                result.add( myNumber );
            }
        }


        return result;
    }

    boolean canIncrease( int[] work ) {

        int base = work.length;

        for ( int i = base - 1; i >= 0; i-- ) {
            if ( work[i] < base - 1 ) {
                work[i]++;
                return true;
            } else if ( work[i] == base - 1 ) {
                work[i] = 0;
                continue;
            }
        }

        return false;
    }

    boolean checkForOkNumber( int[] work ) {
        for ( int i = work.length - 1; i >= 0; i-- ) {

            if ( !checkForValue( work.length - 1 - i, work[work.length - 1 - i], work ) ) {
                return false;
            }
        }

        return true;
    }

    boolean checkForValue( int value, int numOfValues, int[] work ) {

        int occurances = numOfValues;

        for ( int w : work ) {
            if ( w == value ) {
                occurances--;
            }

            if ( occurances < 0 ) {
                return false;
            }
        }

        return occurances == 0;
    }

    private long createNumber( int[] work ) {

        long result = 0;
        for ( int i = 0; i < work.length; i++ ) {
            result = (long) (result + work[i] * Math.pow( 10, 2 ));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0; i < work.length; i++ ) {
            stringBuilder.append( "" + work[i] );
        }

        System.out.println( stringBuilder.toString() );


        return result;
    }
}
