package exception;

public class ExceptionB {
    public void run() {
        // Runtime Exceptionはチェックされない例外
        methodThrowableUncheckedException();

        // Exceptionはチェックされる例外
        try {
            methodThrowableCheckedException();
        } catch(Exception e) {
            doNothing();
        } finally {
            doNothing();
        }

    }

    private void methodThrowableCheckedException() throws Exception {

    }

    private void methodThrowableUncheckedException() throws RuntimeException {

    }

    private void doNothing(){}
}
