package note.repository;

import note.main.ClasaException;
import note.model.Nota;

import java.util.List;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote();
	public void readNote(String fisier);
	
}
