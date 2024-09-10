public class HortaComunitaria {

    static class Planta {
        String nome;
        int quantidade;
        int desperdicio;

        Planta(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.desperdicio = 0;
        }

        void registrarColheita(int quantidadeColhida) {
            if (quantidadeColhida > quantidade) {
                System.out.println("Quantidade colhida maior que o disponível. Ajustando.");
                quantidadeColhida = quantidade;
            }
            quantidade -= quantidadeColhida;
            desperdicio += quantidadeColhida - quantidade;
        }

        @Override
        public String toString() {
            return "Planta: " + nome + ", Quantidade disponível: " + quantidade + ", Desperdício: " + desperdicio;
        }
    }

    public static void main(String[] args) {
        ArrayList<Planta> plantas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Planta");
            System.out.println("2. Registrar Colheita");
            System.out.println("3. Mostrar Status da Horta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da planta: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade inicial: ");
                    int quantidade = scanner.nextInt();
                    plantas.add(new Planta(nome, quantidade));
                    System.out.println("Planta adicionada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o nome da planta para colheita: ");
                    nome = scanner.nextLine();
                    Planta plantaParaColheita = null;
                    for (Planta planta : plantas) {
                        if (planta.nome.equals(nome)) {
                            plantaParaColheita = planta;
                            break;
                        }
                    }
                    if (plantaParaColheita != null) {
                        System.out.print("Digite a quantidade colhida: ");
                        int quantidadeColhida = scanner.nextInt();
                        plantaParaColheita.registrarColheita(quantidadeColhida);
                        System.out.println("Colheita registrada com sucesso.");
                    } else {
                        System.out.println("Planta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Status da Horta:");
                    for (Planta planta : plantas) {
                        System.out.println(planta);
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
