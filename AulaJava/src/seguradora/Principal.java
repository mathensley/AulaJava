package seguradora;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int x = -1, y = 0, i, tam, func, visi;
		float imovel;
		double porce, d;
		String nome, cpf, rg, tel, cnh, cnpj, voltar, end, zona, resi, ramo, str = "urbana", casa = "casa";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		ArrayList<Contrato> list = new ArrayList<Contrato>();
		
		Scanner in = new Scanner(System.in);
		
		while(x != 0){
			System.out.println("-----MENU-----\n"
					+ "\n1-Cadastrar Cliente"
					+ "\n2-Cadastrar Contrato"
					+ "\n3-Lista de Clientes"
					+ "\n4-Lista de Contratos"
					+ "\n0-Sair");
			x = in.nextInt();
			switch(x){
				case 1:
					System.out.println("Pessoa Fisica ou Juridica:\n"
							+ "\n1-Fisica"
							+ "\n2-Juridica");
					y = in.nextInt();
					if(y == 1){
						System.out.println("Cadastrar Cliente\n"
								+ "\nNome: ");
						nome = in.next();
						System.out.println("CPF: ");
						cpf = in.next();
						System.out.println("RG: ");
						rg = in.next();
						System.out.println("TELEFONE: ");
						tel = in.next();
						System.out.println("CNH: ");
						cnh = in.next();
						
						PessoaF pessoaf = new PessoaF(cpf, rg, nome, tel, cnh);
						lista.add(pessoaf);
						break;
					}
					else{
						System.out.println("Cadastrar Cliente\n"
								+ "\nNOME: ");
						nome = in.next();
						System.out.println("\nCPF: ");
						cpf = in.next();
						System.out.println("\nRG: ");
						rg = in.next();
						System.out.println("\nTELEFONE: ");
						tel = in.next();
						System.out.println("\nCNPJ: ");
						cnpj = in.next();
						
						PessoaJ pessoaj = new PessoaJ(cpf, rg, nome, tel, cnpj);
						lista.add(pessoaj);
						break;
					}
				case 2:
					System.out.println("Contrato Residencial ou Empresarial:\n"
							+ "\n1-Residencial"
							+ "\n2-Empresarial");
					y = in.nextInt();
					
					if(y == 1){
						System.out.println("Cadastro de Contrato\n"
								+ "\nNOME CLIENTE: ");
						nome = in.next();
						System.out.println("\nENDERECO: " );
						end = in.next();
						System.out.println("\nVALOR DO IMOVEL: " );
						imovel = in.nextFloat();
						System.out.println("\nZONA DO IMOVEL: ");
						zona = in.next();
						System.out.println("\nTIPO DE RESIDENCIA: ");
						resi = in.next();
						
						porce = (2 * imovel)/100;
						
						if(zona.equals(str))
							porce = porce + (imovel / 100);
						else
							porce = porce + (0.5 * imovel)/100;
						if(resi.equals(casa))
							porce = porce + (0.5 * imovel)/100;
						
						Residencial residencial = new Residencial(imovel, nome, porce, end, zona, resi);
						list.add(residencial);
						break;
					}
					else{
						System.out.println("Cadastro de Contrato\n"
								+ "\nNOME CLIENTE: ");
						nome = in.next();
						System.out.println("\nVALOR DO IMOVEL: " );
						imovel = in.nextFloat();
						System.out.println("\nNUMERO DE FUNCIONARIOS: ");
						func = in.nextInt();
						System.out.println("\nNUMERO DE VISTAS/DIA: ");
						visi = in.nextInt();
						System.out.println("\nRAMO: ");
						ramo = in.next();
						
						porce = (4 * imovel)/100;
						
						if((func / 10) >= 1){
							d = func / 10;
							i = (int) d;
							porce = porce + (i * 0.2);
						}
						if((visi / 200) >= 1){
							d = visi / 200;
							i = (int) d;
							porce = porce + (i * 0.3);
						}
						
						Empresarial empresarial = new Empresarial(imovel, nome, porce, func, visi, ramo);
						list.add(empresarial);
						break;
					}
				case 3:
					tam = lista.size();
					System.out.println("LISTA DE CLIENTES");
					for(i = 0; i < tam; i++){
						System.out.println("\nCliente " + (i+1) + ":");
						System.out.println(lista.get(i));
					}
					System.out.println("Digite qualquer coisa para voltar...");
					voltar = in.next();
					voltar = "";
					break;
				case 4:
					tam = list.size();
					System.out.println("LISTA DE CONTRATOS");
					for(i = 0; i < tam; i++){
						System.out.println("\nContrato " + (i+1) + ":");
						System.out.println(list.get(i));
					}
					System.out.println("Digite qualquer coisa para voltar...");
					voltar = in.next();
					voltar = "";
				default:
					break;
			}
		}
		
		in.close();
	}
}
