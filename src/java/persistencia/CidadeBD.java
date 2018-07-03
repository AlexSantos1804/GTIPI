package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Cidade;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CidadeBD {
    
    private static String caminho = "C:\\Users\\Alexsandro\\Desktop\\GTIPI\\";
    
    private static ArrayList<Cidade> lista = new ArrayList<Cidade>();
    //adiciona um objeto da classe Cidade 
    //na lista que simula o banco de dados
    public static void inserir(Cidade cidade){
        lerXml(); //lê o XML e preenche a lista de Cidade
        
        //pega o último usuário cadastrado
        int ultimaPosicao = lista.size()-1;
        if (ultimaPosicao >= 0){ //se a lista não estiver vazia
            Cidade ultimoCidade = lista.get(ultimaPosicao);
            cidade.setCodigo(ultimoCidade.getCodigo()+1);
        }else{
            //se não tem ninguém na lista, o código é 1
            cidade.setCodigo(1);
        }
        
        
        lista.add(cidade); //adiciona um Cidade no final da lista
        salvarXml(); //atualiza o XML com o que tem na lista
    }
    
    
    public static void alterar(Cidade cidade){
        lerXml();
        excluir(cidade.getCodigo());
        inserir(cidade);
        salvarXml();
    }
    
    //recebe o atributo que identifica cada objeto
    //da classe Cidade
    public static void excluir(int codigo){
        lerXml();
        for(int i=0; i < lista.size(); i++){
            Cidade cadaCidade = lista.get(i);
            
            //procura o cidade que tem o CPF igual 
            //Ã  variÃ¡vel "cpf", que tÃ¡ chegando entre
            //os parÃªnteses
            if (cadaCidade.getCodigo() == codigo){
                lista.remove(i);
            }
        }
        salvarXml();
    }
    public static ArrayList<Cidade> listar(){     
        lerXml();
        //retorna todos os objetos do banco de dados
        return lista;
    }
    
    public static Cidade getByNome(String nome){
        lerXml();
        Cidade cidadeEncontrado = null;
        for(int i=0; i < lista.size(); i++){
            Cidade cadaCidade = lista.get(i);
            
            //procura o cidade que tem o CPF igual 
            //Ã  variÃ¡vel "cpf", que tÃ¡ chegando entre
            //os parÃªnteses
            if (cadaCidade.getNome().equals(nome)){
                cidadeEncontrado = cadaCidade;
                break;
            }
        }
        return cidadeEncontrado;
    }
    
    
    private static void lerXml(){
        File arquivo=new File(caminho + "cidadees.xml");
        if (arquivo.exists()){
            //armazenar XML no vetor
            XStream xstream=new XStream();
            xstream.alias("cidade",Cidade.class);
            lista = (ArrayList<Cidade>) xstream.fromXML(arquivo);
        }else{
            lista = new ArrayList<Cidade>();
        }
    }
    
    private static void salvarXml(){
        XStream xstream = new XStream();
        xstream.alias("cidade",Cidade.class);
        try{
            FileWriter escritor=new FileWriter(caminho + "cidadees.xml");
            escritor.write( xstream.toXML(lista) );
            escritor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
