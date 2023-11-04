package _22010310010_Saliha_Albayrak;

import java.util.Objects;

public class _22010310010_yol {
	@Override
	public int hashCode() {
		return Objects.hash(sonraki, uzaklik);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		_22010310010_yol other = (_22010310010_yol) obj;
		return Objects.equals(sonraki, other.sonraki) && uzaklik == other.uzaklik;
	}
	_22010310010_sehir sonraki;
	int uzaklik;
	_22010310010_yol(_22010310010_sehir sonraki,int uzaklik ) {
		this.sonraki=sonraki;
		this.uzaklik=uzaklik;
	}
}
