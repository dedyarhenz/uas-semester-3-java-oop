package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int ch=0;
        int chk=0;
        ArrayList<komputer> komp=new ArrayList<komputer>();

        Scanner inp = new Scanner(System.in);
        while(ch!=-1){
            menu1();
            System.out.println("pilih menu : ");
            ch=inp.nextInt();
            switch (ch){
                case 1:
                    menu2();
                    System.out.println("pilih menu : ");
                    ch=inp.nextInt();
                    switch (ch){
                        case 1:
                            create(ch, komp);
                            break;
                        case 2:
                            create(ch, komp);
                            break;
                        case 3:
                            ch=0;
                            break;
                    }
                    break;
                case 2:
                    if(komp.isEmpty()){
                        System.out.println("belum ada komputer yang di buat");
                    }else {
                        showkomputer(komp);
                        System.out.println("pilih komputer yang ingin di pakai : ");
                        chk=inp.nextInt();
                        while(chk<=komp.size() && ch!=0){
                            menu3();
                            System.out.println("pilih menu :");
                            ch=inp.nextInt();
                            switch (ch){
                                case 1:
                                    komp.get(chk-1).spesifikasi();
                                    break;
                                case 2:
                                    simpanInput(komp, chk-1);
                                    break;
                                case 3:
                                    hapusfile(komp, chk-1);
                                    break;
                                case 4:
                                    tampilFile(komp, chk-1);
                                    break;
                                case 5:
                                    hardiskTerpakai(komp, chk-1);
                                    break;
                                case 6:
                                    ch=0;
                                    break;
                            }
                        }
                    }

                    break;
                case 3:
                    ch=-1;
                    break;

            }
        }


    }

    public static void menu1(){
        System.out.println("\n1. create komputer ");
        System.out.println("2. show komputer ");
        System.out.println("3. exit ");
    }

    public static void menu2(){
        System.out.println("\n1. Laptop ");
        System.out.println("2. Netbook ");
        System.out.println("3. back ");
    }

    public static void menu3(){
        System.out.println("\n1. spesifikasi ");
        System.out.println("2. simpan data ");
        System.out.println("3. hapus data ");
        System.out.println("4. tampilkan semua data ");
        System.out.println("5. hardisk yang terpakai ");
        System.out.println("6. back");

    }

    public static void showkomputer(ArrayList<komputer> ar){
        for (int a=0; a<ar.size(); a++){
            System.out.println((a+1)+" "+ar.get(a).getNama_komputer());
        }
    }

    public static void create(int c, ArrayList<komputer> a){
        Scanner inp = new Scanner(System.in);
        System.out.println("masukan nama komputer : ");
        String nama=inp.next();
        System.out.println("masukan operating system komputer : ");
        String os=inp.next();
        System.out.println("masukan kecepatan processor : ");
        int proc=inp.nextInt();
        System.out.println("masukan kapasitas ram dalam GB : ");
        int ram=inp.nextInt();
        System.out.println("masukan kapasitas vga dalam GB : ");
        int vga=inp.nextInt();
        System.out.println("masukan kapasitas hdd dalam MB :");
        int hdd=inp.nextInt();

        if (c==1){
            a.add(new Laptop(nama, os, ram, proc, vga, hdd));
        }
        if (c==2){
            a.add(new Netbook(nama, os, ram, proc, vga, hdd));
        }
        System.out.println("berhasil dibuat ");
    }

    public static void simpanInput(ArrayList<komputer> x, int c){
        Laptop lapku;
        Netbook netku;
        Scanner inp = new Scanner(System.in);

        System.out.println("masukan nama file : ");
        String nama=inp.next();
        System.out.println("masukan format file : ");
        String format=inp.next();
        System.out.println("masukan ukuran file dalam MB : ");
        int ukuran=inp.nextInt();

        if (x.get(c) instanceof Laptop){
            lapku=(Laptop)x.get(c);
            lapku.simpanData(nama, format, ukuran);
        }

        if (x.get(c) instanceof Netbook){
            netku=(Netbook)x.get(c);
            netku.simpanData(nama, format, ukuran);
        }



    }

    public static void tampilFile(ArrayList<komputer> x, int c){
        Laptop lapku;
        Netbook netku;
        if (x.get(c) instanceof Laptop){
            lapku=(Laptop)x.get(c);
            lapku.lihatSemuaData();
        }

        if (x.get(c) instanceof Netbook){
            netku=(Netbook)x.get(c);
            netku.lihatSemuaData();
        }
    }

    public static void hardiskTerpakai(ArrayList<komputer> x, int c){
        Laptop lapku;
        Netbook netku;
        if (x.get(c) instanceof Laptop){
            lapku=(Laptop)x.get(c);
            System.out.println("penyimpanan yang terpakai "+lapku.jumlahData()+" MB dari "+lapku.getHdd()+" MB");
        }

        if (x.get(c) instanceof Netbook){
            netku=(Netbook)x.get(c);
            netku.lihatSemuaData();
            System.out.println("penyimpanan yang terpakai "+netku.jumlahData()+" MB dari "+netku.getHdd()+" MB");
        }
    }

    public static  void hapusfile(ArrayList<komputer> x, int c){
        Laptop lapku;
        Netbook netku;
        Scanner inp = new Scanner(System.in);
        System.out.println("masukan urutan data ke berapa yang igin dihapus : ");
        int pilihan=inp.nextInt();

        if (x.get(c) instanceof Laptop){
            lapku=(Laptop)x.get(c);
            lapku.hapusData(pilihan);
        }

        if (x.get(c) instanceof Netbook){
            netku=(Netbook)x.get(c);
            netku.hapusData(pilihan);
        }
    }

}
