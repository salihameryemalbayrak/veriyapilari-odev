package _22010310010_Saliha_Albayrak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class _22010310010_main {

	public static void main(String[] args) throws FileNotFoundException {
		File dosya= new File ("Bilgiler.txt");
		Scanner file = new Scanner(dosya);
		Scanner input = new Scanner(System.in);
		LinkedList<_22010310010_kisi> kisiler = new LinkedList<_22010310010_kisi>();
		LinkedList<_22010310010_sehir> sehirler = new LinkedList<_22010310010_sehir>();
		sehirler= scanSehirler(file,sehirler);
		sehirler= scanGraf(file,sehirler); 
		file.nextLine();
		while(!file.next().equals("KiÅŸilerin")){
			file.nextLine();
		}
		scanKisiler(file,kisiler,sehirler);
		
		
		try {
			
		System.out.println("Varış süresi hesaplanacak olan kişinin ismini giriniz:");
		String kisi= input.next();
		getKisi(kisiler,kisi).toplamYol();                      //bunlari sillllllllllll ama hesap yapsın
		getKisi(kisiler,kisi).varisSuresi();
		System.out.println(kisi+" "+ getKisi(kisiler,kisi).sonDurak().isim+" varış süresi "+getKisi(kisiler,kisi).varisSuresi+" dk");
				
		System.out.println("Toplam yol uzunluğu hesaplanacak olan kişinin ismini giriniz:");
		kisi= input.next();
		System.out.println(kisi+" "+ getKisi(kisiler,kisi).sonDurak().isim+" toplam yol uzunluğu "+getKisi(kisiler,kisi).toplamyol+" km");
		
		System.out.println("Kimin hangi saat itibariyle hangi noktada olduğunu hesaplamak için, aralarında bir boşluk bırakarak kişi ismini ve saati giriniz:");
		kisi= input.next();
		String saat= input.next();
		System.out.println(kisi+" "+saat+" itibariyle");
		getKisi(kisiler,kisi).bulunduguKonum(saat);       
		
		System.out.println("İki şehir arasında direkt yol olup olmadığını sorgulamak için şehir isimlerini aralarında bir boşluk bırakarak giriniz:");
		
		String sehir=input.next();
		String sehir2=input.next();
				
			if(getSehir(sehirler,sehir).direktYol(getSehir(sehirler,sehir2))) {
				System.out.println(sehir+" "+sehir2+" arasında direkt yol var");
			}
			else {
				System.out.println(sehir+" "+sehir2+" arasında direkt yol yok");
			}
		}
		catch(Exception e) {
			System.out.println("girdiğiniz eleman bulunamıyor");
		}
		input.close();
	}
	public static LinkedList<_22010310010_sehir> scanSehirler(Scanner input,LinkedList<_22010310010_sehir> sehirler) {
		input.nextLine();
    	
		while(input.hasNext()) {
			String isim=input.next();
			int kod=input.nextInt();
			if(isim.equals("Graf:")) {
				break;
			}
			_22010310010_sehir s= new _22010310010_sehir(isim,kod);
			sehirler.add(s);
		}
		return sehirler;
		
	}
	
	public static LinkedList<_22010310010_sehir> scanGraf(Scanner input, LinkedList<_22010310010_sehir> sehirler) {
		input.nextLine();
		int i=input.nextInt();
		while(i<=sehirler.size()) {
			int j=1;
			_22010310010_sehir s= getSehir2(sehirler,i);
        	while(j<=sehirler.size()) {
        		int mesafe=input.nextInt();
        		if(s.kod==j) {
        			j++;
        		}
        		else {
        			s.yolEkle(getSehir2(sehirler,j), mesafe);
        			j++;
        		}
        	}
        	if(input.hasNextInt()){
        		i=input.nextInt();
        	}
        	else {
        		break;
        	}        	
        	}
        return sehirler;
	}
	public static void scanKisiler(Scanner input, LinkedList<_22010310010_kisi> kisiler ,LinkedList<_22010310010_sehir> sehirler) {
		input.nextLine();
		while(input.hasNext()) {
			_22010310010_kisi biri =new _22010310010_kisi(input.next());
			scanRota(input.next(),biri,sehirler);
			biri.hiz=input.nextDouble();
			kisiler.add(biri);
			input.next();
		}
	}
	
	public static void scanRota(String rota, _22010310010_kisi kisi ,LinkedList<_22010310010_sehir> sehirler) {
		String s="";
		for(int i=0;i<rota.length();i++) {
			if(rota.charAt(i)=='-'){
				_22010310010_sehir r= getSehir(sehirler,s);
				kisi.rota.add(r);
				s="";
			}
			else {
				s=s+rota.charAt(i);
			}
		}
		_22010310010_sehir r= getSehir(sehirler,s);
		kisi.rota.add(r);
	}
	
	public static _22010310010_kisi getKisi(LinkedList<_22010310010_kisi> liste, String arananisim) throws IndexOutOfBoundsException{
		int i=0;
		while(!(liste.get(i).name).equals(arananisim)) {
			i++;
			if(i>liste.size()-1) {
				throw new IndexOutOfBoundsException();			
			}
		}
		return liste.get(i);

	}
	
	public static _22010310010_sehir getSehir(LinkedList<_22010310010_sehir> liste, String aranansehir) throws IndexOutOfBoundsException{
		int i=0;
		while(!(liste.get(i).isim).equals(aranansehir)) {
			i++;
			if(i>liste.size()-1) {
				throw new IndexOutOfBoundsException();			
			}
		}
		return liste.get(i);
	}
	
	public static _22010310010_sehir getSehir2(LinkedList<_22010310010_sehir> liste, int aranansehirkodu) throws IndexOutOfBoundsException{

		int i=0;
		while(!((liste.get(i).kod)==(aranansehirkodu))) {
			i++;
			if(i>liste.size()-1) {
				throw new IndexOutOfBoundsException();			
			}
		}
		return liste.get(i);
	}
	

}



















