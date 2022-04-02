package FileInfo;

public class Builder
{
    private final String[] log;

    /**
     * The {@code Model} class can do something. You can only construct it through a {@code Builder}.
     *
     * @see Builder
     */
    public class Model
    {
        private final Builder builder;

        /**
         * Constructs a new {@code Model} with the specified argument.
         *
         * @param builder the {@code Builder} that constructed the model.
         */
        public Model(final Builder builder)
        {
            this.builder = builder;
        }

        /**
         * Returns the associated {@code Builder}.
         *
         * @return the builder that constructed the model.
         */
        public Builder getBuilder()
        {
            return this.builder;
        }
    }

    /**
     * Constructs a new instance of the {@code Builder} class with the specified argument.
     *
     * @param log the log of the {@code Builder}.
     */
    public Builder(final String... log)
    {
        this.log = log;
    }

    /**
     * Tries to {@code build} a new instance of the {@code Model} class.
     *
     * @return the constructed {@code Model}.
     */
    public Model build()
    {
        return new Model(this);
    }

    /**
     * Returns the log of the {@code Builder}.
     *
     * @return an log.
     */
    public String[] getLog()
    {
        return this.log;
    }

    /**
     * Determines whether or not the {@code Builder} is valid.
     *
     * @return {@code true} when the specified {@code log} is not {@code null}; {@code false} otherwise.
     */
    public boolean isValid()
    {
        return this.log != null;
    }
}
