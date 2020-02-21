package demo

import org.scalajs.dom
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.{Hooks, ReactElement}
import slinky.web.ReactDOM
import slinky.web.html._
import typings.materialUiCore.createMuiThemeMod.Theme
import typings.materialUiCore.withStylesMod.CSSProperties
import typings.materialUiCore.textFieldTextFieldMod.StandardTextFieldProps
import typings.materialUiCore.{materialUiCoreStrings => MuiStrings, components => Mui}
import typings.react.AnonChildren

import scala.scalajs.js
import scala.scalajs.js.|

object Demo {

  def main(argv: Array[String]): Unit =
    ReactDOM.render(
      div(
        ButtonTest("dear user")
//        SimpleBadge.Component.props(new SimpleBadge.Props("yey"))
      ),
      dom.document.getElementById("container")
    )
}

@react
object ButtonTest {
  case class Props(name: String)

  val component = FunctionalComponent[Props] { props =>
    /* use a hook to keep state */
    val (state, setState) = Hooks.useState(1)

    val incrementButton = Mui.Button(onClick := (() => setState(state + 1)))(
      s"Increment it, ${props.name}"
    )

    div(
      /* a cake icon to celebrate */
//      MuiIcons.CakeOutlined.props(MuiIcons.CakeOutlinedProps(color = MuiStrings.action)),
      /* text field controlled by the value of the state hook above*/
      Mui.TextField(value := state.toString, disabled := true),
      incrementButton
    )
  }
}
//
//// https://github.com/mui-org/material-ui/blob/master/docs/src/pages/demos/badges/SimpleBadge.js
//object SimpleBadge {
//  trait StyleOverrides[T] extends js.Object {
//    val margin:  T
//    val padding: T
//  }
//
//  val styles: js.Function1[Theme, StyleOverrides[CSSProperties]] = theme =>
//    new StyleOverrides[CSSProperties] {
//      override val margin = new CSSProperties {
//        margin = theme.spacing.unit * 2
//      }
//      override val padding = new CSSProperties {
//        padding = s"0 ${theme.spacing.unit * 2}px"
//      }
//    }
//
//  class Props(val message: String) extends js.Object
//
//  val Component: FC[Props] = StyledFC[StyleOverrides, Props](styles) { props =>
//    div.noprops(
//      div.noprops(
//        Mui.Badge.props(
//          Mui.BadgeProps(
//            children     = MuiIcons.Mail.noprops(),
//            className    = props.classes.margin,
//            badgeContent = 4,
//            color        = MuiStrings.primary
//          )
//        ),
//        Mui.Badge.props(
//          Mui.BadgeProps(
//            children     = MuiIcons.Mail.noprops(),
//            className    = props.classes.margin,
//            badgeContent = 10,
//            color        = MuiStrings.secondary
//          )
//        ),
//        Mui.IconButton.props(
//          Mui.IconButtonProps(
//            `aria-label` = s"4 pending messages",
//            className    = props.classes.margin,
//            children = Mui.Badge.props(
//              Mui.BadgeProps(badgeContent = 4, color = MuiStrings.primary, children = MuiIcons.MailOutline.noprops())
//            )
//          )
//        )
//      ),
//      Mui.AppBar.props(
//        Mui.AppBarProps(position = MuiStrings.static, className = props.classes.margin),
//        Mui.Tabs.props(
//          Mui.TabsProps(value = 0),
//          Mui.Tab.props(
//            Mui.TabProps(
//              label = Mui.Badge.props(
//                Mui.BadgeProps(
//                  children     = s"Item One, ${props.message}",
//                  className    = props.classes.padding,
//                  color        = MuiStrings.secondary,
//                  badgeContent = 4
//                )
//              )
//            )
//          )
//        )
//      ),
//      Mui.Badge.props(
//        Mui.BadgeProps(
//          children     = Mui.Typography.props(Mui.TypographyProps(className = props.classes.padding), "Typography"),
//          color        = MuiStrings.primary,
//          badgeContent = 4,
//          className    = props.classes.margin
//        )
//      ),
//      Mui.Badge.props(
//        Mui.BadgeProps(
//          children     = Mui.Button.props(Mui.ButtonProps(variant = MuiStrings.contained), "Button"),
//          color        = MuiStrings.primary,
//          badgeContent = 4,
//          className    = props.classes.margin
//        )
//      )
//    )
//  }
//}
//
///* A facade to define functional components making use of `withStyles` */
//object StyledFC {
//  import scala.language.higherKinds
//
//  @inline private def stylesMod = typings.atMaterialUiCore.stylesMod.asInstanceOf[js.Dynamic]
//
//  trait GeneratedClassNames[Styles[_] <: js.Object] extends js.Object {
//    val classes: Styles[String]
//  }
//
//  @inline def apply[Styles[_] <: js.Object, P <: js.Object](
//      styles: Styles[CSSProperties] | js.Function1[Theme, Styles[CSSProperties]]
//  )(f:        js.Function1[P with AnonChildren with GeneratedClassNames[Styles], ReactNode]): FC[P] =
//    stylesMod.withStyles(styles.asInstanceOf[js.Any])(f).asInstanceOf[FC[P]]
//}
