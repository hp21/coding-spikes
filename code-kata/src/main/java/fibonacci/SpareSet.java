package fibonacci;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public class SpareSet {


    public SpareSet() {
    }

    Set<Set<Integer>> buildSets( Integer numberOfElements ) {

        Preconditions.checkNotNull( "numberOfElements can not be null" );

        if ( numberOfElements == 0 ) {
            HashSet<Set<Integer>> myRet = new HashSet<>();
            myRet.add( new HashSet<>() );
            return myRet;
        }

        if ( numberOfElements == 1 ) {
            return Sets.newHashSet( new HashSet<>(), new HashSet( Sets.newHashSet( 1 ) ) );
        }

        Set<Set<Integer>> s_1 = buildSets( numberOfElements - 1 );
        Set<Set<Integer>> s_2 = buildSets( numberOfElements - 2 );

        HashSet<Set<Integer>> myRet2 = new HashSet<Set<Integer>>();
        for ( Set<Integer> mySet : s_2 ) {
            mySet.add( numberOfElements );
            myRet2.add( mySet );
        }

        HashSet<Set<Integer>> returnValue = new HashSet<Set<Integer>>();
        returnValue.addAll( s_1 );
        returnValue.addAll( myRet2 );

        return returnValue;

    }

}
