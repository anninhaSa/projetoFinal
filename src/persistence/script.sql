CONN SYSTEM JOSEFINA

-- Ao invéns de criar um Database em SYSTEM para cada programa, foi criado um usuário para cada 
-- programa
    CREATE USER salao -- Usuário
IDENTIFIED BY   salao -- Senha
   DEFAULT TABLESPACE USERS;
   
-- Dando permissão de conexão ao usuário salao
GRANT CONNECT TO salao;

-- Dando permissão de escrita ao usuário salao
GRANT RESOURCE TO salao;

-- Me disconectar do usuário SYSTEM
DISC;

-- Me conectar ao usuário salao
CONN salao/salao;

-- Excluir usuário
DROP USER salao CASCADE;


INSERT INTO PESSOA ( IDPESSOA, CPF, DATANASC, NOME, RG, TPPESSOA )
            VALUES ( 1, NULL, TO_DATE( '03/11/1986', 'dd/mm/yyyy' ), 'Anna', NULL, 3 );
            
INSERT INTO FUNCIONARIO ( IDPESSOA )
                 VALUES ( 1 );
COMMIT;
            
SELECT * FROM PESSOA;

SELECT * FROM FUNCIONARIO;

SELECT * FROM autenticacao;