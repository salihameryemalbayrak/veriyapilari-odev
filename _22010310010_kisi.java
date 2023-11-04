package _22010310010_Saliha_Albayrak;

import java.util.*;

public class _22010310010_kisi {
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
		_22010310010_kisi other = (_22010310010_kisi) obj;
		return getName() != null ? getName().equals(other.getName()):other.getName()== null;
		
		
	}
	
	String name;
	double hiz;
	LinkedList<_22010310010_sehir> rota;
	int toplamyol;
	int varisSuresi;
	
	_22010310010_kisi(String name,double hiz){
		this.name=name;
		this.hiz=hiz;
		this.rota= new LinkedList<_22010310010_sehir>();
		this.toplamyol=this.toplamYol();
		this.varisSuresi=this.varisSuresi();
	}
	_22010310010_kisi(String name){
		this.name=name;
		this.hiz=hiz;
		this.rota= new LinkedList<_22010310010_sehir>();
		this.toplamyol=this.toplamYol();
		this.varisSuresi=this.varisSuresi();
	}
	public String getName() {
		return name;
	}
	public void rotayaEkle(_22010310010_sehir s) {              
		rota.add(s);
	}
	public int toplamYol() {
		int i=0;
		int yol =0;
		while(i<rota.size()-1) {
			int ek=this.rota.get(i).mesafe(this.rota.get(i+1));
			yol=yol+ek;
			i++;
		}
		this.toplamyol=yol;
		return yol;
	}
	public int varisSuresi() {
		int dk=(int)(this.toplamyol/this.hiz);
		this.varisSuresi=dk;
		return dk;
	}
	public void bulunduguKonum(String saat) {
		int dk=0;
		int current=0;
		dk=((int)saat.charAt(0)-48)*600+((int)saat.charAt(1)-48)*60+((int)saat.charAt(3)-48)*10+((int)saat.charAt(4)-48);
		dk=dk-(8*60);
		while(dk>0&&rota.size()>current+1) {
			int ssu=(rota.get(current).mesafe(rota.get(current+1))/(int)this.hiz);              
			if(ssu>dk) {
				break;
			}
			dk=dk-ssu;
			current++;
		}
		if(current+1>=rota.size() || dk==0) {
		
			System.out.println("bulunduğu konum: "+(rota.get(current).isim)+"");
		}
		else {
			System.out.println((rota.get(current).isim+" ve "+rota.get(current+1).isim+" arasındadır"));
		}
	}
	public _22010310010_sehir sonDurak() {
		return rota.get(rota.size()-1);
	}
}













