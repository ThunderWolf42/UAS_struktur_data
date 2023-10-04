import java.util.Scanner;
import java.util.*;
class Graph_DFS {
    // Array of Lists untuk Adjacency List Representation
    private final int V; // Jumlah vertices
    // Array of lists untuk representasi adjacency list
    private final LinkedList<Integer> adj[];
    Graph_DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
    // Fungsi untuk menambahkan edge ke dalam graf
    void addEdge(int v, int w) {
        adj[v].add(w); // Menambahkan w ke dalam daftar v
    }
    // Fungsi rekursif untuk traversal DFS
    void DFSutil(int v, boolean visited[]) {
        // Tandai node saat ini telah dikunjungi dan cetak nilainya
        visited[v] = true;
        System.out.print(v + " ");
        // Melakukan iterasi untuk semua node yang terhubung dengan node ini
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSutil(n, visited);
        }
    }
    // Fungsi untuk melakukan DFS traversal pada graf
    void DFS(int v) {
        // Menandai semua vertex belum dikunjungi
        // (secara default false di Java)
        boolean visited[] = new boolean[V];
        // Panggil fungsi rekursif pembantu untuk mencetak DFS traversal
        DFSutil(v, visited);
    }
}
class Graph_BFS {
    private final int V; // Jumlah vertex
    private final LinkedList<Integer> adj[]; // Daftar Adjacency

    // Constructor
    Graph_BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
    // Fungsi untuk menambahkan edge ke grafik
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    // Mencetak BFS traversal dari sumber yang diberikan s
    void BFS(int s) {
        // Tandai semua simpul sebagai belum dikunjungi
        // (secara default disetel sebagai false)
        boolean visited[] = new boolean[V];
        // Buat antrian (queue) untuk BFS
        LinkedList<Integer> queue = new LinkedList<>();
        // Tandai node saat ini sebagai dikunjungi dan masukkan ke dalam antrian (queue)
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            // Ambil vertex dari antrian (queue) dan cetak
            s = queue.poll();
            System.out.print(s + " ");
            // Dapatkan semua simpul yang berdekatan yang belum dikunjungi, tandai
            // mereka sebagai dikunjungi dan masukkan ke dalam antrian (queue)
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}


public class Graph {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            char pilihan;
            do {
                System.out.println("\nGraph Operations\n");
                System.out.println("1.Graph DFS");
                System.out.println("2.Graph BFS");
                 int pilihan_angka = scan.nextInt();
                switch (pilihan_angka) {
                    case 1:
                        Graph_DFS D = new Graph_DFS(6);
                        D.addEdge(1,2);
                        D.addEdge(1,3);
                        D.addEdge(2,1);
                        D.addEdge(2,5);
                        D.addEdge(3,3);
                        D.addEdge(3,4);
                        D.addEdge(4,2);
                        D.addEdge(5,4);
                        System.out.println("Following is depth first traversal "+"(starting from vertex 1)");
                        D.DFS(1);
                        break;
                    case 2:
                        Graph_BFS B = new Graph_BFS(6); //
                        B.addEdge(1,2);
                        B.addEdge(1,3);
                        B.addEdge(2,1);
                        B.addEdge(2,5);
                        B.addEdge(3,3);
                        B.addEdge(3,4);
                        B.addEdge(4,2);
                        B.addEdge(5,4);
                        System.out.println("Following is Breadth first traversal "+"(starting from vertex 1)");
                        B.BFS(1);
                        break;
                    default:
                        System.out.println("Wrong Entry \n");
                        break;
                }
                System.out.print("\nhasil nya: ");
                System.out.println("\nApakah ingin melanjutkan lagi ? ( y or t) \n");
                pilihan = scan.next().charAt(0);
            }
            while (pilihan != 't');
            System.out.println("Terima kasih ");
        }
}
