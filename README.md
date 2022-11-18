# Projeto de teste de software 💻

## Requisitos funcionais 📜:

- [ ]  **Cadastro de usuário**. Cada usuário tem nome, email e senha. O email deve ser válido e a senha precisa ter as seguintes características:
    - [ ]  Validação de email
    - [ ]  Comprimento da senha: mínimo de oito caracteres
    - [ ]  Caracteres numéricos: mínimo de dois números
    - [ ]  Caracteres especiais: mínimo de um caractere especial
    - [ ]  Letras maiúsculas: mínimo de uma letra maiúscula
    - [ ]  Letras minúsculas: mínimo de uma letra minúscula
- [ ]  O sistema deve calcular as raízes de uma [função de 2º Grau](https://mundoeducacao.uol.com.br/matematica/funcao-2-grau.htm)
- [ ]  O sistema deve informar se três valores reais que representam ângulos formam um [triângulo](https://educacao.uol.com.br/disciplinas/matematica/soma-dos-angulos-internos-de-um-triangulo-por-que-a-soma-vale-sempre-180suposup.htm). Lembrando que a soma dos valores dos ângulos internos de um triângulo é 180º
    - [ ]  Validar se algum dos ângulos é zero ou negativo
- [ ]  O sistema deve classificar como [triângulo retângulo, acutângulo e obtusângulo](https://escolakids.uol.com.br/matematica/classificacao-dos-triangulos.htm#:~:text=Podemos%20classificar%20os%20tri%C3%A2ngulos%20de,tri%C3%A2ngulos%20ret%C3%A2ngulos%2C%20acut%C3%A2ngulos%20ou%20obtus%C3%A2ngulos.) se os valores dos ângulos correspondem a um triângulo.
- [ ]  O sistema deve informar se três valores lidos correspondem aos lados de um [triângulo retângulo](https://mundoeducacao.uol.com.br/matematica/triangulo-retangulo.htm#:~:text=Chamamos%20de%20hipotenusa%20o%20maior,igual%20ao%20quadrado%20da%20hipotenusa.)
- [ ]  O sistema deve informar se quatro valores reais lidos representam um retângulo.
- [x]  O sistema deve calcular área e perímetro, se dois valores reais lidos representarem um retângulo
- [x]  O sistema deve ter uma função de calculadora para as operações:
    - [x]  Soma de dois valores
    - [x]  Subtração de dois valores
    - [x]  Multiplicação de dois valores
    - [x]  Divisão de dois valores
    - [x]  Potência
- [x] O sistema deve calcular a área e o perímetro de um círculo, a partir de um valor que represente um raio.
- [x] O sistema deve calcular a distância entre dois pontos (p1 e p2) quaisquer no plano cartesiano. Para isso, deve ler quatro valores correspondentes a x1 e y1, coordenadas de p1, e x2 e y2, de p2.


# Requisitos não funcionais

- Interface amigável;
- Linguagem de programação Java.

---

## [Validação de email](https://www.baeldung.com/java-email-validation-regex)

A validação de email será feita através de expressão regular. A expressão irá permitir:

- Números de 0 a 9;
- Letras de a até z maiúsculas e minúsculas;
- Caracteres especiais como “_”, “-” e “.”, com a ressalva de que:
    - O ponto “.” não é permitido nem no fim nem no começo do nome do email;
    - Pontos consecutivos não são permitidos;
    - O “-” e o “.” não são permitidos nem no fim nem no começo do domínio.
- Tamanho máximo de 64 caracteres para o nome do email.

## [Sobre a colorização no terminal](diogonunes.com/blog/jcolor-java-color-messages-terminal/)