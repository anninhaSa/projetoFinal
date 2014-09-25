CONN SYSTEM JOSEFINA

-- Ao inv�ns de criar um Database em SYSTEM para cada programa, foi criado um usu�rio para cada 
-- programa
    CREATE USER salao -- Usu�rio
IDENTIFIED BY   salao -- Senha
   DEFAULT TABLESPACE USERS;
   
-- Dando permiss�o de conex�o ao usu�rio salao
GRANT CONNECT TO salao;

-- Dando permiss�o de escrita ao usu�rio salao
GRANT RESOURCE TO salao;

-- Me disconectar do usu�rio SYSTEM
DISC;

-- Me conectar ao usu�rio salao
CONN salao/salao;

-- Excluir usu�rio
DROP USER salao CASCADE;


INSERT INTO PESSOA ( IDPESSOA, CPF, DATANASC, NOME, RG, TPPESSOA )
            VALUES ( 1, NULL, TO_DATE( '03/11/1986', 'dd/mm/yyyy' ), 'Anna', NULL, 3 );
            
INSERT INTO FUNCIONARIO ( IDPESSOA )
                 VALUES ( 1 );
COMMIT;
            
SELECT * FROM PESSOA;

SELECT * FROM FUNCIONARIO;

SELECT * FROM autenticacao;