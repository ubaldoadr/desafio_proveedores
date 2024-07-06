package cl.praxis.model.dao;

import java.util.List;

import cl.praxis.model.dto.ProvDTO;

public interface ProveedoresDAO {

	void create(ProvDTO p);

	ProvDTO read(int id);

	List<ProvDTO> read();

	void update(ProvDTO a);

	String delete(int id);
}
