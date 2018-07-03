package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Funcionario;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FuncionarioBD {
    
    private static String caminho = "C:\\Users\\Alexsandro\\Desktop\\GTIPI\\";
    
    private static ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
    //adiciona um objeto da classe Funcionario 
    //na lista que simula o banco de dados
    public static void inserir(Funcionario funcionario){
        lerXml(); //lê o XML e preenche a lista de Funcionario
        
        //pega o último usuário cadastrado
        int ultimaPosicao = lista.size()-1;
        if (ultimaPosicao >= 0){ //se a lista não estiver vazia
            Funcionario ultimoFuncionario = lista.get(ultimaPosicao);
            funcionario.setCodigo(ultimoFuncionario.getCodigo()+1);
        }else{
            //se não tem ninguém na lista, o código é 1
            funcionario.setCodigo(1);
        }
        
        
        lista.add(funcionario); //adiciona um Funcionario no final da lista
        salvarXml(); //atualiza o XML com o que tem na lista
    }
    
    
    public static void alterar(Funcionario funcionario){
        lerXml();
        excluir(funcionario.getCodigo());
        inserir(funcionario);
        salvarXml();
    }
    
    //recebe o atributo que identifica cada objeto
    //da classe Funcionario
    public static void excluir(int codigo){
        lerXml();
        for(int i=0; i < lista.size(); i++){
            Funcionario cadaFuncionario = lista.get(i);
            
            //procura o funcionario que tem o CPF igual 
            //Ã  variÃ¡vel "cpf", que tÃ¡ chegando entre
            //os parÃªnteses
            if (cadaFuncionario.getCodigo() == codigo){
                lista.remove(i);
            }
        }
        salvarXml();
    }
    public static ArrayList<Funcionario> listar(){     
        lerXml();
        //retorna todos os objetos do banco de dados
        return lista;
    }
 
    private static void lerXml(){
        File arquivo=new File(caminho + "funcionarioes.xml");
        if (arquivo.exists()){
            //armazenar XML no vetor
            XStream xstream=new XStream();
            xstream.alias("funcionario",Funcionario.class);
            lista = (ArrayList<Funcionario>) xstream.fromXML(arquivo);
        }else{
            lista = new ArrayList<Funcionario>();
        }
    }
    
    private static void salvarXml(){
        XStream xstream = new XStream();
        xstream.alias("funcionario",Funcionario.class);
        try{
            FileWriter escritor=new FileWriter(caminho + "funcionarioes.xml");
            escritor.write( xstream.toXML(lista) );
            escritor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static Funcionario procurarPorLoginSenha(String login, String senha){
        Funcionario funcionarioEncontrado = null;
        lerXml();
        for(int i=0; i < lista.size(); i++){
            Funcionario funcionario = lista.get(i);
            if( funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)){
                funcionarioEncontrado = funcionario;
                break;
            }
        }
        return funcionarioEncontrado;
    }
    
    
}
