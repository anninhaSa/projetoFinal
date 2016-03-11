package validate;

import java.util.InputMismatchException;

import org.apache.commons.lang.StringUtils;

import util.StatusRetorno;
import entity.Cliente;

/**
 * Classe responsavel por validar os dados do cliente.
 */
public class ValidadorPessoa {
	
    ValidadorContato validadorContato;
    
    public StatusRetorno aplica(Cliente cliente) {
        validadorContato = new ValidadorContato();
		StatusRetorno sRet = new StatusRetorno();
		
		sRet = validaNome(cliente);
		
		if(sRet.isOk()) {
		    sRet = validaCPF(cliente.getCPF());
		}
		
		if(sRet.isOk()) {
		    sRet = validadorContato.aplica(cliente.getContato());
		}
		
		return sRet;
	}

	private StatusRetorno validaNome(Cliente cliente) {
	    StatusRetorno sRet = new StatusRetorno();
		
		if(StringUtils.trimToNull(cliente.getNome()) == null) {
			sRet.setMsgErro("Nome inválido!");
		}
		
		return sRet;
	}
	
	public StatusRetorno validaCPF(String cpf) {
	    StatusRetorno sRet = new StatusRetorno();
	    
		if(StringUtils.isEmpty(cpf)) {
		    return sRet;
		}
		
		cpf = cpf.replaceAll("[.]", "").replaceAll("[-]", "");
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||
		    cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
		    cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
		    cpf.equals("99999999999") || cpf.length() != 11) {
			sRet.setMsgErro("CPF inválido!");
		    return sRet;
		}

		char dig10,
		     dig11;

		int sm   = 0,
		    i    = 0,
		    r    = 0,
		    num  = 0,
		    peso = 0;

		try {
			// Calculo do 1o. Digito Verificador sm = 0; 
			peso = 10;

			for (i=0; i<9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num  = (int)(cpf.charAt(i) - 48);
				sm  +=  (num * peso);
				--peso;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			} else {
				dig10 =  (char)( r + 48 );
			}

			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador

			sm   = 0;
			peso = 11;

			for(i=0; i<10; i++) {
				num = (int)(cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char)( r + 48 );
			}

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
				return sRet;
			} else {
				sRet.setMsgErro("CPF inválido!");
			}
		} catch (InputMismatchException erro) {
			sRet.setMsgErro("CPF inválido!");
		}
		return sRet;
	}
}