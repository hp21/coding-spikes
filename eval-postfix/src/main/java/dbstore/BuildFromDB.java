package dbstore;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import tree.Node;

public class BuildFromDB {


    public Node<Integer> buildFromDB( List<Item> items ) {

        Map<Integer, Node<Integer>> buildMap = new HashMap<>();

        List<Item> itemList = Optional.ofNullable( items ).orElse( Collections.emptyList() );

        Set<Integer> missed = new HashSet<>(  );

        for ( Item item : itemList ) {
            Node<Integer> node = new Node<>();
            node.setData( item.id );
            buildMap.putIfAbsent( node.getData(), node );

            if ( rootItem( item ) ) {
                continue;
            }

            Node<Integer> parent = findParent( buildMap, node.getParent() );
            if ( parent==null ){
                missed.add( node.getData() );
            }

           // parent.setLeft(  );


        }


        return null;
    }

    private Node<Integer> findParent( Map<Integer, Node<Integer>> buildMap, Node<Integer> parentKey ) {
        return buildMap.get( parentKey );
    }

    private boolean rootItem( Item item ) {
        return item.parent == null;
    }


    private class Item {
        Integer id;
        Integer parent;

        public Item( Integer id, Integer parent ) {
            this.id = id;
            this.parent = parent;
        }

    }
}
