package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.Hooks._
import slinky.core.facade.ReactElement
import slinky.native.ScrollView
import typings.antDesignReactNative.components.{List => AntdList, _}
import typings.antDesignReactNative.{PartialLocale, antDesignReactNativeStrings => antdStrings}
import typings.bang88ReactNativeDrawerLayout.mod.DrawerLayout
import typings.reactRouter.components.Route
import typings.reactRouter.mod.RouteProps
import typings.reactRouterNative.components.NativeRouter

import scala.scalajs.js.|

@react object App {

  type Props = Unit

  val component = FunctionalComponent[Props] { _ =>
    var ref: DrawerLayout | Null = null

    val (redirPath, updateRedirPath) = useState(RoutePath.HOME.path)

    val menus = RoutePath.allOrdered.indices.map(index =>
      ListItem(
        onPress = () => {
          updateRedirPath(RoutePath.allOrdered(index).path)
          ref.asInstanceOf[DrawerLayout].closeDrawer()
        }
      )(RoutePath.allOrdered(index).title).withKey(index.toString)
    )

    Provider(locale = PartialLocale(locale = "enUS"))(
      Drawer(
        drawerRef = (ref = _),
        sidebar = ScrollView(WhiteSpace(size = antdStrings.xl), AntdList(menus))
      )(
        NativeRouter(
          AntdList(renderHeader = WhiteSpace(size = antdStrings.xl): ReactElement)(
            ListItem(
              extra = Icon(name = "menu"),
              onPress = () => ref.asInstanceOf[DrawerLayout].openDrawer()
            )("React Native demo")
          ),
          Route(RouteProps(path = RoutePath.HOME.path, render = props => Home(redirPath, props.`match`), exact = true)),
          Route(RouteProps(path = RoutePath.ANTD.path, render = props => Antd(redirPath, props.`match`))),
          Route(RouteProps(path = RoutePath.REACTROUTER.path, render = props => ReactRouter(redirPath, props.`match`)))
        )
      )
    )
  }
}
