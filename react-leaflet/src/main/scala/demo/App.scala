package demo

import slinky.core._
import slinky.core.annotations.react
import typings.leaflet.mod.LatLngExpression
import typings.reactLeaflet.components.{Map, Marker, Popup, TileLayer}
import typings.reactLeaflet.mod.{MapProps, MarkerProps, TileLayerProps}

import scala.language.implicitConversions
import scala.scalajs.js

@react object App {
  type Props = Unit

  val component = FunctionalComponent[Props] { _ =>
    val position: LatLngExpression = js.Tuple2(51.505, -0.09)

    Map(MapProps(center = position, zoom = 13))(
      TileLayer(
        TileLayerProps(
          url = "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
          attribution = "&copy; <a href=&quot;http://osm.org/copyright&quot;>OpenStreetMap</a> contributors"
        )
      ),
      Marker(MarkerProps(position = position))(
        Popup("A pretty CSS3 popup.\nEasily customizable.")
      )
    )
  }
}
