package repast.simphony.context.space.graph;

import repast.simphony.context.Context;
import repast.simphony.space.graph.EdgeCreator;
import repast.simphony.space.graph.Network;
import repast.simphony.space.graph.RepastEdge;

/**
 * Factory for creating networks.
 *
 * @author Nick Collier
 * @version $Revision$ $Date$
 */
public class DefaultNetworkFactory implements NetworkFactory {

  protected DefaultNetworkFactory() {

  }

  /**
   * Creates a Network that will contain the specified class of objects. Any
   * objects in the context will be added as nodes in the returned Network,
   * but any edges created are local to the network itself. The network is
   * added to the specified Context as a projection and can be retrieved from
   * the Context with <code>Context.getProjection(networkName)</code>. If a
   * network with the specified name has already been created, that already
   * created network will be returned.
   *
   * @param netName    the name of the network
   * @param context    the context of which the network will be a projection
   * @param isDirected whether or not the network should be directed
   * @return the created network.
   */
  public <T> Network<T> createNetwork(String netName, Context<T> context,
                                      boolean isDirected) {
    NetworkBuilder<T> builder = new NetworkBuilder<T>(netName, context, isDirected);
    return builder.buildNetwork();
  }

  /**
   * Creates a Network that will contain the specified class of objects. Any
   * objects in the context will be added as nodes in the returned Network,
   * but any edges created are local to the network itself. The network is
   * added to the specified Context as a projection and can be retrieved from
   * the Context with <code>Context.getProjection(networkName)</code>. If a
   * network with the specified name has already been created, that already
   * created network will be returned.
   *
   * @param netName    the name of the network
   * @param context    the context of which the network will be a projection
   * @param isDirected whether or not the network should be directed
   * @return the created network.
   */
  public <T> Network<T> createNetwork(String netName, Context<T> context, NetworkGenerator<T> generator, boolean isDirected) {
    NetworkBuilder<T> builder = new NetworkBuilder<T>(netName, context, isDirected);
    return builder.setGenerator(generator).buildNetwork();
  }

  /**
   * Creates a Network that will contain the specified class of objects. Any
   * objects in the context will be added as nodes in the returned Network,
   * but any edges created are local to the network itself. The network is
   * added to the specified Context as a projection and can be retrieved from
   * the Context with <code>Context.getProjection(networkName)</code>. If a
   * network with the specified name has already been created, that already
   * created network will be returned.
   *
   * @param netName     the name of the network
   * @param context     the context of which the network will be a projection
   * @param isDirected  whether or not the network should be directed
   * @param generator   used to create the initial network topology. Note that
   *                    there must be enough objects in the context to create the topology
   * @param edgeCreator the class used to create edges for this network
   * @return the created network.
   */
  public <T> Network<T> createNetwork(String netName, Context<T> context, boolean isDirected,
                                      NetworkGenerator<T> generator,
                                      EdgeCreator<? extends RepastEdge<T>, T> edgeCreator) {

    NetworkBuilder<T> builder = new NetworkBuilder<T>(netName, context, isDirected);
    return builder.setEdgeCreator(edgeCreator).setGenerator(generator).buildNetwork();

  }

  /**
   * Creates a Network that will contain the specified class of objects. Any
   * objects in the context will be added as nodes in the returned Network,
   * but any edges created are local to the network itself. The network is
   * added to the specified Context as a projection and can be retrieved from
   * the Context with <code>Context.getProjection(networkName)</code>. If a
   * network with the specified name has already been created, that already
   * created network will be returned.
   *
   * @param netName     the name of the network
   * @param context     the context of which the network will be a projection
   * @param isDirected  whether or not the network should be directed
   * @param edgeCreator the class used to create edges for this network
   * @return the created network.
   */
  public <T> Network<T> createNetwork(String netName, Context<T> context, boolean isDirected,
                                      EdgeCreator<? extends RepastEdge<T>, T> edgeCreator) {
    NetworkBuilder<T> builder = new NetworkBuilder<T>(netName, context, isDirected);
    return builder.setEdgeCreator(edgeCreator).buildNetwork();
  }
}
