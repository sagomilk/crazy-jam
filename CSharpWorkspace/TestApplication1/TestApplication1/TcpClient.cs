using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using FeatureSamples.FeatureService;
using System.ServiceModel;

namespace FeatureSamples
{

    class Preference
    {
        public static String ENDPOINT_CONFIG_NAME = "FeatureServiceInterface";
        public static String DEFAULT_SERVICE_URL = "http://localhost:8080/soap/FeatureService";

        // This is used to create an client interface to the Feature service.
        public static FeatureServiceInterfaceClient getServiceInterface()
        {
            // create the client to communicate to the service.
            // can also use the empty client constructor as below
            // FeatureServiceInterfaceClient client = new FeatureServiceInterfaceClient();

            // In this case, the default value for the 2 parameters are set in the app.config file.
            // app.config is a configuration file generated when the Visual Studio imports a service WSDL.
            // the remote address will be default to the service URL entered for the WSDL.
            // FeatureServiceInterfaceClient client = new FeatureServiceInterfaceClient(ENDPOINT_CONFIG_NAME, DEFAULT_SERVICE_URL);

            // Create client with Basic authentication
            BasicHttpBinding binding = new BasicHttpBinding();
            binding.SendTimeout = TimeSpan.FromSeconds(25);
            binding.Security.Mode = System.ServiceModel.BasicHttpSecurityMode.TransportCredentialOnly;
            binding.Security.Transport.ClientCredentialType = System.ServiceModel.HttpClientCredentialType.Basic;

            EndpointAddress address = new EndpointAddress(DEFAULT_SERVICE_URL);
            FeatureServiceInterfaceClient client = new FeatureServiceInterfaceClient(binding, address);
            // set username and password
            client.ClientCredentials.UserName.UserName = "guest";
            client.ClientCredentials.UserName.Password = "";

            return client;
        }
    }


}//End of HelloService Namespace