package br.edu.iftm.model.service.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.iftm.model.dao.CategoriaDao;
import br.edu.iftm.model.domain.Categoria;
import br.edu.iftm.model.service.ICategoriaService;

@Path("/categoria")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CategoriaService implements ICategoriaService {
		
		@Inject
		private CategoriaDao categoriaDao;
		
		@Override
		@POST
		public void salvar(Categoria categoria){
			categoriaDao.salvar(categoria);
		}

		@Override
		@PUT
		public void atualizar(Categoria categoria){
			categoriaDao.atualizar(categoria);
		}
		
		@Override
		@DELETE
		@Path("/{codigo}")
		public void excluir(@PathParam(value="codigo") Integer codigo){
			categoriaDao.excluir(codigo);
		}
		
		@Override
		@GET
		public List<Categoria> buscar(Categoria categoria){
			return categoriaDao.buscar(categoria);
		}
		
		@GET
		@Path("/{codigo}")
		public Categoria buscar(@PathParam(value="codigo") Integer codigo){
			return categoriaDao.buscarPorId(codigo);
		}
}
