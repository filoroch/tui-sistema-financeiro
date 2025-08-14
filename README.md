# Sistema Financeiro TUI

## Descrição

Um sistema de gerenciamento financeiro simples com interface de terminal (TUI) usando JLine para Java.

## Estrutura do Projeto

```
src/
├── main/java/br/org/zephyr/
│   ├── model/
│   │   ├── Transacao.java      # Entidade principal
│   │   └── TipoTransacao.java  # Enum dos tipos
│   ├── controller/
│   │   └── TransacaoController.java # Controlador MVC
│   └── view/
│       └── App.java            # Interface principal
├── test/java/                  # Testes unitários
├── .devcontainer/              # Dev Container config
├── pom.xml                     # Configuração Maven
└── README.md                   # Documentação do projeto
```

## Diagrama de Classes (MVC)

```mermaid
classDiagram
class Transacao{
+UUID id
+String descricao
+Double valor
+LocalDate createdAt
+TipoTransacao tipoTransacao
}
class TipoTransacao{<<enumeration>>}
class TransacaoController{
+List<Transacao> transacoes
+criarTransacao(String,Double,TipoTransacao) Transacao
+listarTransacoes() void
+adicionarTransacao(Transacao) void
+editarTransacao(UUID,String,TipoTransacao) void
+excluirTransacao(int) void
+bucarTransacao(UUID) Transacao
}
class App{+main(String[]) void}
App --> TransacaoController : usa
TransacaoController *-- Transacao : gerencia
Transacao o-- TipoTransacao : tipo
namespace br.org.zephyr.model{Transacao
TipoTransacao}
namespace br.org.zephyr.controller{TransacaoController}
namespace br.org.zephyr.view{App}
```

## Funcionalidades

### ✅ CRUD de Transações

- **Create**: Criação de novas transações com validação de dados
- **Read**: Listagem e visualização de transações com formatação
- **Update**: Edição de transações existentes por ID
- **Delete**: Exclusão segura com confirmação

### ✅ Interface JLine

- Menu interativo no terminal
- Navegação intuitiva com opções numeradas
- Formatação rica de saída de dados
- Validação de entrada do usuário

### ✅ Arquitetura MVC

- Separação clara de responsabilidades
- Baixo acoplamento entre camadas
- Código testável e maintível
- Estrutura organizacional consistente

## Roadmap

- [x] Construir as classes base do MVC
- [x] Implementar operações CRUD básicas
- [x] Criar interface TUI com menu
- [ ] Adicionar persistência com H2 Database
- [ ] Implementar validações avançadas
- [ ] Adicionar importação/exportação CSV
- [ ] Criar testes unitários abrangentes
- [ ] Adicionar suporte a múltiplas contas
- [ ] Implementar filtros e buscas avançadas
- [ ] Criar relatórios financeiros
- [ ] Adicionar gráficos ASCII para visualização

## Contribuindo

1. Fork o projeto
2. Crie sua feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Links Úteis

- [JLine Documentation](https://github.com/jline/jline3/wiki)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Dev Containers Documentation](https://containers.dev/)
- [Mermaid Documentation](https://mermaid.js.org/)

---
**Desenvolvido com ❤️ usando Java, Maven e JLine**
