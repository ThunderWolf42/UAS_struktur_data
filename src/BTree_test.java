
    public class BTree_test{
        public static void main (String[]args)
        {
            BTree b = new BTree(5);
            b.insert(51);
            b.insert (60);
            b.insert (7);
            b.insert (8);
            b.insert (12);
            b.insert (23);
            b.insert (14);
            b.display ();
        }
    }
