package _22010310010_Saliha_Albayrak;

import java.util.*;

public class _22010310010_sehir {
	String isim;
	int kod;
	LinkedList<_22010310010_yol> yollar;
	
	_22010310010_sehir(String isim,int kod){
	
		this.isim=isim;
		this.kod=kod;
		LinkedList<_22010310010_yol> yollar = new LinkedList<_22010310010_yol>();
		this.yollar=yollar;
		
	}
	_22010310010_sehir(String isim){
		
		this.isim=isim;
		this.kod=kod;
		LinkedList<_22010310010_yol> yollar = new LinkedList<_22010310010_yol>();
		this.yollar=yollar;
		
	}
	
	public String getName() {
		return isim;
	}
	public int getKod() {
		return kod;
	}
	
	@Override
	public int hashCode() {
		return getName()!=null? getName().hashCode(): 0 ;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		_22010310010_sehir other = (_22010310010_sehir) obj;
		return getName() != null ? getName().equals(other.getName()):other.getName()== null;
		
		
	}
	
	public void yolEkle(_22010310010_sehir sonraki,int uzaklik) {
		_22010310010_yol y= new _22010310010_yol(sonraki,uzaklik);
		yollar.add(y);
	}
	public int mesafe(_22010310010_sehir gidilecekyer) {
		for(int i=0;i<yollar.size();i++) {
			if((yollar.get(i).sonraki).equals(gidilecekyer)) {
				return yollar.get(i).uzaklik;
			}
		}
		return 0;
	}
	public boolean direktYol(_22010310010_sehir aranansehir) {
		for(int i=0;i<yollar.size();i++) {
			if((yollar.get(i).sonraki).equals(aranansehir)) {
				if(yollar.get(i).uzaklik!=0) {
					return true;
				}
			}
		}
		return false;
	}
}






























