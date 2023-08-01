package clients;

import exception.BanksException;

/**
 *Represents a client of a bank.
 * A client is identified by their name, surname, passport, and address.
 * Clients can be checked for doubtfulness by checking whether their passport and address are empty strings.
 * Clients can also be built using a ClientBuilder object, which allows for creating a client object with only the necessary fields.
 * @author Kurilova Viktoriia
 */
public record Client(String name, String surname, String passport, String address) {
    /**
     * Checks whether the client is doubtful or not.
     * A client is considered doubtful if their passport and address fields are both empty.
     * @return true if the client is not doubtful (i.e., if either their passport or address fields are not empty); false otherwise.
     */
    public boolean notDoubtful() {
        return passport.isEmpty() && address.isEmpty();
    }

    /**
     * Checks whether the client's name field is empty, and throws a BanksException if it is.
     * @throws BanksException if the client's name field is empty.
     */
    public void checkName() {
        if (name.isEmpty()) {
            throw new BanksException("You should fill the gaps");
        }
    }

    /**
     * Checks whether the client's surname field is empty, and throws a BanksException if it is.
     * @throws BanksException if the client's surname field is empty.
     */
    public void checkSurname() {
        if (surname.isEmpty()) {
            throw new BanksException("You should fill the gaps");
        }
    }

    /**
     * A builder class for creating a client object with only the necessary fields.
     * Allows for creating a client object without specifying all the fields, as long as the name and surname fields are given.
     */
    public static class ClientBuilder {
        private String name = null;
        private String surname = null;
        private String passport = null;
        private String address = null;

        /**
         * Sets the name field for the client.
         * @param name the name of the client.
         * @return the client builder object.
         */
        public ClientBuilder setName(String name) {
            name = name;
            return this;
        }

        /**
         * Sets the surname field for the client.
         * @param surname the surname of the client.
         * @return the client builder object.
         */
        public ClientBuilder setSurname(String surname) {
            surname = surname;
            return this;
        }

        /**
         * Sets the passport field for the client.
         * @param passport the passport of the client.
         * @return the client builder object.
         */
        public ClientBuilder setPassport(String passport) {
            passport = passport;
            return this;
        }

        /**
         * Sets the address field for the client.
         * @param address the address of the client.
         * @return the client builder object.
         */
        public ClientBuilder setAddress(String address) {
            address = address;
            return this;
        }

        /**
         * Builds a client object with the specified fields.
         * @return a new client object.
         */
        public Client build() {
            return new Client(name, surname, passport, address);
        }
    }
}
