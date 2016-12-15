
// os dados estão nas coleções e maps 
//map de clientes dá uma tabela de identificadores de clientes 


public class ViaVerde {



 
//private Map<String, Cliente> clientes; 
	private ClienteDAO clientes; 

public Set<String> getIds(String c){
	Cliente cliente = this.clientes.get(c); 

	return cliente.getIds();
}


public class Cliente{

	//private Collection<Identificador> identificadores; 
	private IdentificadorDAO identificadores; 

	public Set<String> getIds(){
		Set<String> res = new TreeSet<String>();

		for(Identificador ident: this.identificadores.getAll())
			res.add(ident.getCodId());

		return res; 
	}
}


}

