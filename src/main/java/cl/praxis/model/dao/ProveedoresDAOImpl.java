package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cl.praxis.model.conexion.Conexion;
import cl.praxis.model.dto.ProvDTO;

public class ProveedoresDAOImpl implements ProveedoresDAO {

	@Override
	public void create(ProvDTO p) {

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "insert into proveedores (nombre, rut, direccion, correo, telefono, contacto,telefono_contacto) values "
					+ "('" + p.getNombre() + "','" + p.getRut() + "','" + p.getDireccion() + "','" + p.getCorreo()
					+ "','" + p.getTelefono() + "','" + p.getContacto() + "','" + p.getTelefono_contacto() + "')";

			ResultSet re = s.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println("ERROR en create(proveedores)");
			e.printStackTrace();
		}

	}

	@Override
	public ProvDTO read(int id) {
		ProvDTO p = null;

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre, rut, direccion, correo, telefono, contacto,telefono_contacto from proveedores where id = "
					+ id;
			System.out.println(sql);
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				p = new ProvDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("rut"), rs.getString("direccion"),
						rs.getString("correo"), rs.getString("telefono"), rs.getString("contacto"),
						rs.getString("telefono_contacto"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR en read(id)");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<ProvDTO> read() {
		List<ProvDTO> proveedores = new ArrayList<ProvDTO>();

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre, rut, direccion, correo, telefono, contacto,telefono_contacto from proveedores order by nombre asc";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				proveedores.add(new ProvDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("rut"),
						rs.getString("direccion"), rs.getString("correo"), rs.getString("telefono"),
						rs.getString("contacto"), rs.getString("telefono_contacto")));

			}

		} catch (SQLException e) {
			System.out.println("ERROR en read()");
			e.printStackTrace();
		}
		return proveedores;
	}

	@Override
	public String delete(int id) {
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "delete from proveedores where  id = " + id;

			ResultSet re = s.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println("ERROR en delete(id)");
			e.printStackTrace();
		}
		return "Borrado";
	}

	@Override
	public void update(ProvDTO a) {
		// TODO Auto-generated method stub
		
	}

}
