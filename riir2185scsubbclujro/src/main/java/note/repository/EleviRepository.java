package note.repository;

import note.model.Elev;

import java.util.List;

public interface EleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
