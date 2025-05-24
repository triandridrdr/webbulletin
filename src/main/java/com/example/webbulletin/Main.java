package com.example.webbulletin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //String input = scan.nextLine();
        String output = "error";
        Double persentasePerTahun;
        Double total=(double) 0;
        Double danaAwal;
        Double labaPerTahun;
        int tahunPenarikan;
        String hasilDanaAwal="gagal";
        String hasilLabaPerTahun="gagal";
        String hasilTahunPenarikan="gagal";
        //String hasilAkhir="error";

        //WRITE YOUR CODE HERE
        System.out.println("Masukan input dana awal : ");
        danaAwal = scan.nextDouble();
        
        System.out.println("Masukan input persentase Laba Per tahun : ");
        labaPerTahun = scan.nextDouble();
        
        System.out.println("Masukan input tahun Penarikan : ");
        tahunPenarikan = scan.nextInt();
        
        
        System.out.println(danaAwal);
        
        //Dana awal : 1.000 <= x <= 1.000.000.000
        //if (x >= 1000 && x <= 1000000000) {
        if(danaAwal >= 1000 && danaAwal<=1000000000) {
        	hasilDanaAwal="sukses";
        }
        
        //Laba per Tahun (%) : 1 <= n <= 20
        if(labaPerTahun >= 1 && labaPerTahun<=20) {
        	hasilLabaPerTahun="sukses";
        }
        
      //Tahun penarikan : 1 <= n <= 40
        if(tahunPenarikan >= 1 && labaPerTahun<=40) {
        	hasilTahunPenarikan="sukses";
        }
        
        if(hasilDanaAwal.equalsIgnoreCase("sukses")&&(hasilLabaPerTahun.equalsIgnoreCase("sukses")&&(hasilTahunPenarikan.equalsIgnoreCase("sukses")))) {
        	
        	persentasePerTahun=danaAwal*((labaPerTahun/100));
        	
        	for(int i=1; i<=tahunPenarikan; i++) {
        		total=total+danaAwal+persentasePerTahun;
        	}
        	
        }
        
        System.out.println("hasilDanaAwal "+hasilDanaAwal);
        System.out.println("hasilLabaPerTahun "+hasilLabaPerTahun);
        System.out.println("hasilTahunPenarikan "+hasilTahunPenarikan);
        
        if(total==0) {
        	output="error";
        	System.out.println("Output : "+output);
        }else {
        	output="success";
        	System.out.println("Output : "+output);
        	System.out.println("Hasil Investasi yang di terima : "+total);
        }
    }
}

