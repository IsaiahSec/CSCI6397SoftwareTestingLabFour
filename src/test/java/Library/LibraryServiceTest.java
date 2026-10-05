package Library;

import java.util.UUID;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {
    // Declare the `LibraryService` object to test its `checkoutResource()` method
    LibraryService service;
    // Mock the dependencies to support testing without emailing users or altering the state of the database
    @Mock EmailProvider emailProvider;
    @Mock ResourceRepository resourceRepository;
    // Valid `id` and `email` parameters shared by the tests; TC05-TC07 pass invalid values directly instead
    UUID id = UUID.randomUUID();
    String email = "test@test.com";

    // Before each test: initialize the object with the mocked dependencies
    @BeforeEach
    void setUp(){

        service = new LibraryService(emailProvider, resourceRepository);
    }

    @Test
    void tc_01() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(true);
        Mockito.when(resourceRepository.updateStatus(id, false)).thenReturn(true);
        Mockito.when(emailProvider.sendEmail(email, "Resource ID: " + id + " checked out.")).thenReturn(true);

        assertTrue(service.checkoutResource(id, email));
    }
    @Test
    void tc_02() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(true);
        Mockito.when(resourceRepository.updateStatus(id, false)).thenReturn(true);
        Mockito.when(emailProvider.sendEmail(email, "Resource ID: " + id + " checked out.")).thenReturn(false);

        EmailFailureException thrown = Assertions.assertThrowsExactly(EmailFailureException.class, () ->
                service.checkoutResource(id, email));

        assertEquals("Email Failed! Could not send email.", thrown.getMessage());
    }
    @Test
    void tc_03() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(true);
        Mockito.when(resourceRepository.updateStatus(id, false)).thenReturn(false);

        DatabaseFailureException thrown = Assertions.assertThrowsExactly(DatabaseFailureException.class, () ->
                service.checkoutResource(id, email));

        assertEquals("Database Failed! Could not check out item.", thrown.getMessage());
    }
    @Test
    void tc_04() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(false);

        assertFalse(service.checkoutResource(id, email));
    }
    @Test
    void tc_05() throws DatabaseFailureException, EmailFailureException {

        assertFalse(service.checkoutResource(null, email));
    }
    @Test
    void tc_06() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(true);
        Mockito.when(resourceRepository.updateStatus(id, false)).thenReturn(true);
        Mockito.when(emailProvider.sendEmail("null", "Resource ID: " + id + " checked out.")).thenReturn(false);

        EmailFailureException thrown = Assertions.assertThrowsExactly(EmailFailureException.class, () ->
                service.checkoutResource(id, "null"));

        assertEquals("Email Failed! Could not send email.", thrown.getMessage());
    }
    @Test
    void tc_07() throws DatabaseFailureException, EmailFailureException {

        Mockito.when(resourceRepository.isResourceAvailable(id)).thenReturn(true);
        Mockito.when(resourceRepository.updateStatus(id, false)).thenReturn(true);
        Mockito.when(emailProvider.sendEmail("test", "Resource ID: " + id + " checked out.")).thenReturn(false);

        EmailFailureException thrown = Assertions.assertThrowsExactly(EmailFailureException.class, () ->
                service.checkoutResource(id, "test"));

        assertEquals("Email Failed! Could not send email.", thrown.getMessage());
    }
}