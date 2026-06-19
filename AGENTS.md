# e-mandai

Spring Boot 4.1.0 REST API (Maven, Java 26). A simple category management service backed by JPA + H2.

## Commands

```powershell
# Run (use mvnw.cmd on Windows, ./mvnw on Unix)
mvnw.cmd spring-boot:run

# Test
mvnw.cmd test
```

## Known quirks

- Uses `spring-boot-starter-webmvc` (not `-web`) — newer Spring Boot 4.x artifact name.
- Java 26 in `pom.xml` (`<java.version>26</java.version>`) — verify it matches your installed JDK.
- Interface named `CategoryScervice` (typo: missing `r`). This is the actual class name used throughout — do not rename unless also updating all references.
- `Category` is a JPA `@Entity` (`@Id`, `@GeneratedValue`) with a `Long categoryId` field (boxed, not `long` primitive — Jackson cannot deserialize `null` into `long`).
- `CategoryRepository` extends `JpaRepository` — no custom queries.
- `CategoryScervice` service interface has a typo (missing `r`) used consistently throughout.
- `H2ConsoleAutoConfiguration` silently fails in Boot 4.1.0 (class name mismatch with H2 2.4.x). The H2 console servlet is registered manually via `H2Config.java`.
- H2 is declared without `<scope>runtime</scope>` (compile scope) so `JakartaWebServlet` is available at compile time for `H2Config.java`.
- `spring.datasource.url` must be set explicitly, otherwise H2 generates a random UUID database name each restart.
- `HELP.md` is gitignored — do not rely on it.

## API

| Method | Endpoint                         | Action         |
|--------|----------------------------------|----------------|
| GET    | `/api/public/categories`         | List all       |
| POST   | `/api/admin/categories`          | Create         |
| DELETE | `/api/admin/categories/{id}`     | Delete         |
| PUT    | `/api/admin/categories/{id}`     | Update         |

## Package layout

```
com.adityababar.e_mandai
├── EMandaiApplication.java          # @SpringBootApplication entrypoint
├── H2Config.java                    # Manual H2 console servlet registration
├── controller/
│   └── CategoryController.java      # @RestController
├── service/
│   ├── CategoryScervice.java        # interface (note typo)
│   └── CategoryServiceImpl.java     # @Service, uses CategoryRepository
├── repositories/
│   └── CategoryRepository.java      # JpaRepository<Category, Long>
└── model/
    └── Category.java                # @Entity(name = "Categories")
```
