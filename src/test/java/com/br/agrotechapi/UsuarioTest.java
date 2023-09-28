// package com.br.agrotechapi;

// import com.br.agrotechapi.models.Usuario;

// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// public class UsuarioTest {

//     @Test
//     public void testConstrutor() {
//         Usuario usuario = new Usuario("João", "12345678900", "joao@example.com", "senha123");

//         assertEquals("João", usuario.getNome());
//         assertEquals("12345678900", usuario.getCpf());
//         assertEquals("joao@example.com", usuario.getEmail());
//         assertEquals("senha123", usuario.getSenha());
//     }

//     @Test
//     public void testSettersAndGetters() {
//         Usuario usuario = new Usuario();

//         usuario.setNome("Maria");
//         usuario.setCpf("98765432100");
//         usuario.setEmail("maria@example.com");
//         usuario.setSenha("senha456");

//         assertEquals("Maria", usuario.getNome());
//         assertEquals("98765432100", usuario.getCpf());
//         assertEquals("maria@example.com", usuario.getEmail());
//         assertEquals("senha456", usuario.getSenha());
//     }

//     @Test
//     public void testIdAutoGerado() {
//         Usuario usuario = new Usuario();

//         assertNull(usuario.getId()); // O ID deve ser nulo antes de ser persistido

//         // Simule a persistência em um banco de dados
//         // userRepository.save(usuario);

//         assertNotNull(usuario.getId()); // O ID deve ser gerado automaticamente após a persistência
//     }
// }
