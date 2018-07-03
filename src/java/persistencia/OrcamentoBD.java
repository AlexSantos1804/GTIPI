package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Orcamento;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class OrcamentoBD {
    
    private static String caminho = "C:\\Users\\Alexsandro\\Desktop\\GTIPI\\";
    
    private static ArrayList<Orcamento> lista = new ArrayList<Orcamento>();
    //adiciona um objeto da classe Orcamento 
    //na lista que simula o banco de dados
    public static void inserir(Orcamento orcamento){
        lerXml(); //lê o XML e preenche a lista de Orcamento
        
        //pega o último usuário cadastrado
        int ultimaPosicao = lista.size()-1;
        if (ultimaPosicao >= 0){ //se a lista não estiver vazia
            Orcamento ultimoOrcamento = lista.get(ultimaPosicao);
            orcamento.setCodigo(ultimoOrcamento.getCodigo()+1);
        }else{
            //se não tem ninguém na lista, o código é 1
            orcamento.setCodigo(1);
        }
        
        
        lista.add(orcamento); //adiciona um Orcamento no final da lista
        salvarXml(); //atualiza o XML com o que tem na lista
    }
    
    
    public static void alterar(Orcamento orcamento){
        lerXml();
        excluir(orcamento.getCodigo());
        inserir(orcamento);
        salvarXml();
    }
    
    //recebe o atributo que identifica cada objeto
    //da classe Orcamento
    public static void excluir(int codigo){
        lerXml();
        for(int i=0; i < lista.size(); i++){
            Orcamento cadaOrcamento = lista.get(i);
            
            //procura o orcamento que tem o CPF igual 
            //Ã  variÃ¡vel "cpf", que tÃ¡ chegando entre
            //os parÃªnteses
            if (cadaOrcamento.getCodigo() == codigo){
                lista.remove(i);
            }
        }
        salvarXml();
    }
    public static ArrayList<Orcamento> listar(){     
        lerXml();
        //retorna todos os objetos do banco de dados
        return lista;
    }
    
    public static Orcamento getByNome(String nome){
        lerXml();
        Orcamento orcamentoEncontrado = null;
        for(int i=0; i < lista.size(); i++){
            Orcamento cadaOrcamento = lista.get(i);
            
            //procura o orcamento que tem o CPF igual 
            //Ã  variÃ¡vel "cpf", que tÃ¡ chegando entre
            //os parÃªnteses
            if (cadaOrcamento.getNome().equals(nome)){
                orcamentoEncontrado = cadaOrcamento;
                break;
            }
        }
        return orcamentoEncontrado;
    }
    
    
    private static void lerXml(){
        File arquivo=new File(caminho + "orcamentoes.xml");
        if (arquivo.exists()){
            //armazenar XML no vetor
            XStream xstream=new XStream();
            xstream.alias("orcamento",Orcamento.class);
            lista = (ArrayList<Orcamento>) xstream.fromXML(arquivo);
        }else{
            lista = new ArrayList<Orcamento>();
        }
    }
    
    private static void salvarXml(){
        XStream xstream = new XStream();
        xstream.alias("orcamento",Orcamento.class);
        try{
            FileWriter escritor=new FileWriter(caminho + "orcamentoes.xml");
            escritor.write( xstream.toXML(lista) );
            escritor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
