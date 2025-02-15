public class DesignWebBrowser {

    public static class Browser {
        static class Node {
            String url;
            Node next, prev;

            Node(String url) {
                this.url = url;
                this.next = null;
                this.prev = null;
            }
        }

        private Node current;

        public Browser(String homePage) {
            current = new Node(homePage);
        }

        public void visit(String url) {
            Node newNode = new Node(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        public void back(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
        }

        public void forward(int steps) {
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
        }

        public String getCurrentPage() {
            return current.url;
        }
    }

    public static void main(String[] args) {
        Browser browser = new Browser("sagar.com");
        browser.visit("google.com");
        browser.visit("microsoft.com");
        browser.visit("facebook.com");

        System.out.println("Current Page: " + browser.getCurrentPage()); // facebook.com

        browser.back(2);
        System.out.println("After going back 2 steps: " + browser.getCurrentPage()); // google.com

        browser.forward(1);
        System.out.println("After going forward 1 step: " + browser.getCurrentPage()); // microsoft.com
    }
}
