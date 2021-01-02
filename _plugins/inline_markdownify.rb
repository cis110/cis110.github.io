module MyFilters
  def strip_p_tags(input)
    input.to_s.gsub(/<\/?p>/, '')
  end

  def inline_markdownify(input)
    strip_p_tags(markdownify(input))
  end

  private
  #def markdownify(input)
    # Copied Jekyll::Filters::markdownify here because idk ruby ~davix
    #site = @context.registers[:site]
    #converter = site.find_converter_instance(Jekyll::Converters::Markdown)
    #converter.convert(input)
  #end
end

Liquid::Template.register_filter(MyFilters)
